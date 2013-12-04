import os
import time
source = ['a', 'b']
# we have to use double quotes inside the string if there is space in name
target_dir ='backup'

today = target_dir + os.sep + time.strftime('%Y%m%d') 
now = time.strftime('%H%M%S')

comment = input('Enter a comment --> ')
if len(comment) == 0:
    target = today + os.sep + now + '.zip'
else:
    target = today + os.sep + now + '_' + comment.replace(' ', '_') + ".zip"

if not os.path.exists(today):
    os.mkdir(today)
    print('Successfully created directory', today)

target = today + os.sep + now + '.zip'
zip_command = "zip -qr {0} {1}".format(target, ' '.join(source))

print(zip_command)

if os.system(zip_command) == 0:
    print('Successful backup to', target)
else:
    print('Backup FAILED')
