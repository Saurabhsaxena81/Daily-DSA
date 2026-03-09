import subprocess
import re

def get_wifi_passwords():
    # 1. Run the command to list all saved Wi-Fi profiles
    try:
        command_output = subprocess.run(["netsh", "wlan", "show", "profiles"], capture_output=True, text=True, check=True).stdout
    except subprocess.CalledProcessError:
        print("Error: Could not retrieve Wi-Fi profiles. Ensure you are running this on Windows.")
        return []

    # 2. Extract profile names using regular expressions
    profile_names = re.findall(r"All User Profile\s*:\s*(.*)", command_output)
    
    wifi_list = []
    
    # 3. Loop through each profile to grab the password
    for name in profile_names:
        name = name.strip() # Remove any trailing spaces
        
        # Run the command to reveal the key for the specific network
        profile_info = subprocess.run(["netsh", "wlan", "show", "profile", name, "key=clear"], capture_output=True, text=True).stdout
        
        # Extract the password (Key Content)
        password_match = re.search(r"Key Content\s*:\s*(.*)", profile_info)
        
        if password_match:
            password = password_match.group(1).strip()
        else:
            password = "[No Password / Open Network]"
            
        wifi_list.append({"SSID": name, "Password": password})
            
    return wifi_list

if __name__ == "__main__":
    passwords = get_wifi_passwords()
    
    if passwords:
        # Format and print the results in a clean table
        print(f"{'Wi-Fi Network Name (SSID)':<30} | {'Password'}")
        print("-" * 60)
        for wifi in passwords:
            print(f"{wifi['SSID']:<30} | {wifi['Password']}")
    else:
        print("No Wi-Fi profiles found.")