import os
import sys


CODE_REPO_9511_URL = "https://github.com/ftc9511/TeamCode"

if "--quiet" in sys.argv:
    existing_library_path = sys.argv[2]
    quiet = True
else:
    existing_library_path = input("Enter absolute path to existing code: ")
    quiet = False

if os.listdir("./TeamCode") and not quiet:
    overwrite = True if input("TeamCode folder already exists, proceed? (y/n) ").lower() == "y" else False

if overwrite:
    os.rmdir("TeamCode")
os.system(f"git clone {CODE_REPO_9511_URL}")
os.system(f"mv ./TeamCode {existing_library_path}/TeamCode/")