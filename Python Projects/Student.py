print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *")
print("*                                                               *")
print("*                   Coded by Vishwas Luhana                     *")
print("*   Mehran University of Engineering and Technology Jamshoro    *")
print("*     Department of Computer Systems Engineering (18-Batch)     *")
print("*                                                               *")
print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *")

def new_student():
    global all_details
    details = []
    while True:
        print("******************************")
        roll_no = input("Enter roll no: ")
        if roll_no in all_details:
            print("Roll no. already exists. Try other roll no.")
        else:
            break
    details.append(roll_no)
    name = input("Enter name: ")
    details.append(name)
    f_name = input("Enter father's name: ")
    details.append(f_name)
    phone = input("Enter contact number: ")
    details.append(phone)
    address = input("Enter address: ")
    details.append(address)
    all_details[roll_no] = details
    print("***********Student successfully added.***********")

def search_student():
    global all_details
    while True:
        roll_no = input("Enter roll no: ")
        if roll_no in all_details:
            print("******************************")
            print("Roll no.: ", all_details[roll_no][0])
            print("Name: ", all_details[roll_no][1])
            print("Father's name: ", all_details[roll_no][2])
            print("Contact: ", all_details[roll_no][3])
            print("Address: ", all_details[roll_no][4])
            print("******************************")
            break
        else:
            print("***********Could not find record with provided roll no.***********")
            if int(input("Enter 1 to re-enter roll no. \nEnter any other key for Main menu \nEnter your choice: ")) == 1:
                continue
            else:
                break

def edit_detials():
    global all_details
    while True:
        roll_no = input("Enter roll no: ")
        if roll_no in all_details:
            print("******************************")
            print("Previous details: ")
            print("Roll no.: ", all_details[roll_no][0])
            print("Name: ", all_details[roll_no][1])
            print("Father's name: ", all_details[roll_no][2])
            print("Contact: ", all_details[roll_no][3])
            print("Address: ", all_details[roll_no][4])

            while True:
                print("******************************")
                print("What do you want to change: ")
                change = int(input("1. Roll no. \n 2. Name \n 3. Father's name \n 4. Contact \n 5. Address\n Your choice: "))
                if change == 1:
                    new_rollNo = input("Enter new Roll no.: ")
                    all_details[new_rollNo] = all_details[roll_no]
                    all_details[new_rollNo][0] = new_rollNo
                    all_details.pop(roll_no)
                    roll_no = new_rollNo
                    del new_rollNo
                    print("***********Roll no. successfully changed***********")

                elif change == 2:
                    all_details[roll_no][1] = input("Enter new Name: ")
                    print("***********Name successfully changed***********")

                elif change == 3:
                    all_details[roll_no][2] = input("Enter new Father's name: ")
                    print("***********Father's name successfully changed***********")

                elif change == 4:
                    all_details[roll_no][3] = input("Enter new Contact: ")
                    print("***********Contact successfully changed***********")

                elif change == 5:
                    all_details[roll_no][4] = input("Enter new Address: ")
                    print("***********Address successfully changed***********")
                else:
                    print("Invalid choice")
                    continue
                if input("Do you want to change anything else? (Y for YES, any other key for NO): ").capitalize() == "Y":
                    continue
                else: break
            break
        else:
            print("***********Could not find record with provided roll no.***********")
            if int(input("Enter 1 to re-enter roll no. \nEnter any other key for Main menu \nEnter your choice: ")) == 1:
                continue
            else:
                break

all_details = {}
while True:
    print("***********Main menu***********")
    print("1. Add new student")
    print("2. Search for existing student")
    print("3. Edit student details")
    print("Enter any other key to close program")
    choice = int(input("Enter your choice: "))

    if choice == 1:
        new_student()
        continue
    elif choice == 2:
        search_student()
    elif choice == 3:
        edit_detials()
    else:
        break
