package assignment;


import java.lang.String;
import java.lang.Thread;
import java.util.regex.Pattern;
import java.util.Scanner;
import assignment.datatype.*;
import assignment.datatype.Date;
import assignment.pay.*;


import java.time.LocalDate;

public class sportCourtReservation {
    
    public static String id="";
    public static int[] time = {10, 12, 14, 16, 18, 20};
    public static Address[] location = {
        new Address("No 123,Taman Baru", "Triang", 28150, "Pahang"),
        new Address("No 567,Jalan Bingo", "Kuala Lumpur", 56000, "Kuala Lumpur")
    };
    public static Date[] preDay = {new Date(31, 12, 2020),new Date(1, 1, 2021),new Date(3, 1, 2021),new Date(5, 1, 2021),new Date(6, 1, 2021)};
    static LocalDate date = LocalDate.now();
    static int todayYear = date.getYear();
    static int todayMonth = date.getMonthValue();
    static int todayDay = date.getDayOfMonth();
    public static Date today = new Date(todayDay, todayMonth, todayYear);
    static LocalDate returnvalue = date.plusDays(1);
    static int nextYear = returnvalue.getYear();
    static int nextMonth = returnvalue.getMonthValue();
    static int nextDay = returnvalue.getDayOfMonth();
    public static Date nextDate = new Date(nextDay, nextMonth, nextYear);
    static LocalDate returnvalue2 = returnvalue.plusDays(1);
    static int next2Year = returnvalue2.getYear();
    static int next2Month = returnvalue2.getMonthValue();
    static int next2Day = returnvalue2.getDayOfMonth();
    public static Date next2Date = new Date(next2Day, next2Month, next2Year);
    public static int countBooking=0;
    
    public static sportCourt[][] courtDetail = {
    {
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[0], time[1], today),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[1], time[2], today),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[2], time[3], today),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[3], time[4], today),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[4], time[5], today)
    }, {
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[0], time[1], today),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[1], time[2], today),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[2], time[3], today),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[3], time[4], today),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[4], time[5], today)
    }, {
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[0], time[1], nextDate),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[1], time[2], nextDate),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[2], time[3], nextDate),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[3], time[4], nextDate),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[4], time[5], nextDate)
    }, {
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[0], time[1], nextDate),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[1], time[2], nextDate),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[2], time[3], nextDate),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[3], time[4], nextDate),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[4], time[5], nextDate)  
    }, {
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[0], time[1], next2Date),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[1], time[2], next2Date),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[2], time[3], next2Date),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[3], time[4], next2Date),
        new sportCourt("B001", location[0], SportCourtStatus.Available, time[4], time[5], next2Date)
    }, {
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[0], time[1], next2Date),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[1], time[2], next2Date),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[2], time[3], next2Date),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[3], time[4], next2Date),
        new sportCourt("B002", location[1], SportCourtStatus.Available, time[4], time[5], next2Date)  
    }};
    public static Booking[][] booking = {{
        new Booking(preDay[0],preDay[1],"ckr","B002","badminton",time[1], time[2],30,ReservationStatus.Completed),
        new Booking(preDay[2],preDay[3],"ckr","B001","badminton",time[3], time[4],30,ReservationStatus.Completed),
        new Booking(preDay[3],preDay[4],"ckr","B001","badminton",time[0], time[1],30,ReservationStatus.Completed),
        new Booking(), new Booking(), new Booking(), new Booking(),new Booking(), new Booking(), new Booking(), new Booking()
    }, {
        new Booking(preDay[1],preDay[2],"erhao","B002","badminton",time[4], time[5],30,ReservationStatus.Completed),
        new Booking(), new Booking(), new Booking(), new Booking(), new Booking(), new Booking(),new Booking(), new Booking(), new Booking(), new Booking()
    }, {
        new Booking(), new Booking(), new Booking(), new Booking(), new Booking(), new Booking(), new Booking(),new Booking(), new Booking(), new Booking(), new Booking()
    }, {
        new Booking(), new Booking(), new Booking(), new Booking(), new Booking(), new Booking(), new Booking()
    }, {
        new Booking(), new Booking(), new Booking(), new Booking(), new Booking(), new Booking(), new Booking()
    }};

    private static Payment payment = new Payment();
    private static Customer[] cus = new Customer[10];
    private static int totalCus = 3;
    private static int count;

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        Person[] examplePerson = {
                new Person("ckr", new Address("1 Jalan Sini Taman Sana", "Petalling", 43300, "Selangor"), "ckr@gmail.com", "013-7121698"),
                new Person("erhao", new Address("2 Jalan Sana Taman Sini", "Muar", 84000, "Johor"), "erhao@gmail.com", "011-12925968"),
                new Person("erhao", new Address("2 Jalan Sana Taman Sini", "Muar", 84000, "Johor"), "erhao@gmail.com", "011-12925968")
        };

        Member[] exampleMembership = {
                new Member(3011,"BASIC",1,35,3.0),
                new Member(3012,"STANDARD",1,50,6.0),
                new Member(3013,"PREMIUM",1,75,10.0)
        };

        Person person;
        Address address;


        cus[0] = new Customer("ckr", "abc12345", examplePerson[0], exampleMembership [0]);
        cus[1] = new Customer("erhao", "12345abc",  examplePerson[1], exampleMembership [1]);
        cus[2] = new Customer("test", "test",  examplePerson[2], exampleMembership [2]);



        int max = 250;
        int cust_id = 3;
        int selection;


        do {
            Thread.sleep(max);
            System.out.print("      ______  ___  _____   ___________ ___________ _____ _____ \n");
            Thread.sleep(max);
            System.out.print("      | ___ \\/ _ \\|  _  | /  ___| ___ \\  _  | ___ \\_   _/  ___|\n");
            Thread.sleep(max);
            System.out.print("      | |_/ / /_\\ \\ | | | \\ `--.| |_/ / | | | |_/ / | | \\ `--. \n");
            Thread.sleep(max);
            System.out.print("      | ___ \\  _  | | | |  `--. \\  __/| | | |    /  | |  `--. \\\n");
            Thread.sleep(max);
            System.out.print("      | |_/ / | | \\ \\_/ / /\\__/ / |   \\ \\_/ / |\\ \\  | | /\\__/ /\n");
            Thread.sleep(max);
            System.out.print("      \\____/\\_| |_/\\___/  \\____/\\_|    \\___/\\_| \\_| \\_/ \\____/ \n");

            System.out.println("========================================================================");
            System.out.println("\t\t\t\t\t1.Login \n\t\t\t\t\t2.Register\n\t\t\t\t\t3.Exit");
            System.out.println("========================================================================");


            System.out.print("Please Enter Your Selection >>>");
            selection = sc.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Welcome To Login Page ");
                    String password;
                    boolean loginError = true;
                    do {
                        System.out.print("Enter User Id :");
                        id = sc.next();
                        
                        sc.nextLine();

                        System.out.print("Enter Password: ");
                        password = sc.nextLine();
                        for (count = 0; count < totalCus; count++) {
                            if (cus[count].getId().equals(id)) {
                                if (cus[count].getPassword().equals(password)) {
                                    loginError = false;
                                    break;
                                }
                            }
                        }
                        if (loginError) {
                            System.out.println(ConsoleColors.RED_BOLD + "Invalid User ID or Password" + ConsoleColors.RESET);
                        }
                    } while (loginError);
                    System.out.println(ConsoleColors.LIGHT_GREEN + "Your Account Has Successfully Signed in" + ConsoleColors.RESET);

                    if(cus[count].getMembership() != null) {
                        payment.setDISCOUNT(((cus[count].getMembership().getDiscount()) / (double)100));
                    }

                    mainMenu();
                    break;

                case 2:
                    System.out.println("Welcome To Register Page");
                    System.out.println("Your Customer Id : C00" + cust_id++);
                    System.out.print("Please Enter Your User Id : ");
                    String new_user_id = sc.next();
                    System.out.print("Please Enter Your Password : ");
                    String new_password = sc.next();
                    sc.nextLine();
                    String new_name;
                    while(true) {
                        System.out.print("Please Enter Your Name : ");
                        new_name = sc.nextLine();
                        if(Pattern.matches("[a-zA-Z ]+", new_name))
                            break;
                        System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter character only.<ERROR>" + ConsoleColors.RESET);
                    }

                    System.out.print("Please Enter Your Street Address : ");
                    String new_street_address = sc.nextLine();
                    String new_city;
                    while(true) {
                        System.out.print("Please Enter Your City : ");
                        new_city = sc.nextLine();
                        if(Pattern.matches("[a-zA-Z ]+", new_city))
                            break;
                        System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter character only.<ERROR>" + ConsoleColors.RESET);
                    }
                    String new_state;
                    while(true) {
                        System.out.print("Please Enter Your State :");
                        new_state = sc.nextLine();
                        if(Pattern.matches("[a-zA-Z ]+", new_state))
                            break;
                        System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter character only.<ERROR>" + ConsoleColors.RESET);
                    }

                    System.out.print("Please Enter Your Post Code : ");
                    int new_post_code = sc.nextInt();

                    sc.nextLine();
                    String new_email;
                    while (true) {
                        System.out.print("Please Enter Your Email Address (include '@' ): ");
                        new_email = sc.nextLine();
                        if (Pattern.matches("^(.+)@(.+)$", new_email))
                            break;
                        System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter a valid phone number(exp: xxx@gmail.com).<ERROR>" + ConsoleColors.RESET);
                    }
                    String new_phone;
                    while (true) {
                        System.out.print("Please Enter Phone Number(include '-' ): ");
                        new_phone = sc.next();
                        if (Pattern.matches("[0-9]{3}-[0-9]{7,8}", new_phone))
                            break;
                        System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter a valid phone number(exp: 011-12345678).<ERROR>" + ConsoleColors.RESET);
                    }
                    address = new Address(new_street_address, new_city, new_post_code, new_state);
                    person = new Person(new_name, address, new_email, new_phone);
                    cus[totalCus++] = new Customer(new_user_id, new_password, person, new Member());
                    System.out.println(ConsoleColors.LIGHT_GREEN + "You Have Successfully Registered !" + ConsoleColors.RESET);
                    break;

                case 3:
                    System.out.println(ConsoleColors.LIGHT_GREEN + "Thanks For Using Our Service " + ConsoleColors.RESET);
                    System.exit(0);
                    break;

                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Please Only Enter 1-3 Only !" + ConsoleColors.RESET);

            }

        } while (selection != 3);
        sc.close();
    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);


        int choice;
        do {
            System.out.println(" _    _   _____   _       _____   _____  ___  ___  _____  ");
            System.out.println("| |  | | |  ___| | |     /  __ \\ |  _  | |  \\/  | |  ___| ");
            System.out.println("| |  | | | |__   | |     | /  \\/ | | | | | .  . | | |__   ");
            System.out.println("| |/\\| | |  __|  | |     | |     | | | | | |\\/| | |  __|  ");
            System.out.println("\\ /  \\ / | |___  | |____ | \\__/\\ \\ \\_/ / | |  | | | |___  ");
            System.out.println(" \\/  \\/  \\____/  \\_____/  \\____/  \\___/  \\_|  |_/ \\____/  ");


            menuList();
            System.out.print("Please Enter The Choice That You Want : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableCourt();
                    break;
                case 2:
                    bookCourt();
                    break;
                case 3:
                    orderDrinks();
                    break;
                case 4:
                    membership();
                    break;
                case 5:
                    userProfile();
                    break;
                case 6:
                    bookingList();
                    break;
                case 7:
                    myPayment();
                    break;
                case 8:
                    System.out.println(ConsoleColors.LIGHT_GREEN + "Your Account Has Successfully Signed Out" + ConsoleColors.RESET);
                    System.out.println("Thanks For Using Our Servie ");
                    System.exit(0);
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Please Only Enter 1-9 Only !" + ConsoleColors.RESET);
            }

        } while (choice != 8);
        sc.close();
    }


    public static void menuList() {
        System.out.println("+-------------------------------+");
        System.out.println("|            MAIN MENU          |");
        System.out.println("+-------------------------------+");
        System.out.println("|   1. VIEW AVAILABLE COURT     |");
        System.out.println("|   2. BOOK COURT               |");
        System.out.println("|   3. BEVERAGE                 |");
        System.out.println("|   4. MEMBERSHIP               |");
        System.out.println("|   5. PROFILE                  |");
        System.out.println("|   6. MY BOOKING               |");
        System.out.println("|   7. MY PAYMENT               |");
        System.out.println("|   8. LOG OUT                  |");
        System.out.println("+-------------------------------+");
    }

    // view available court (no 1)
    public static void viewAvailableCourt() {
        Scanner sc = new Scanner(System.in);
        // option 1
        int option;
        do {
            System.out.println("\n\n+---------------------------------------------------------+");
            System.out.println("|                   VIEW COURT AVAILABLE                  |");
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                      1."+today.toString()+"                       |");
            System.out.println("|                      2."+nextDate.toString()+"                       |");
            System.out.println("|                      3."+next2Date.toString()+"                       |");
            System.out.println("|                      4.ALL                              |");
            System.out.println("|                      5.BACK                             |");
            System.out.println("+---------------------------------------------------------+");
            do {
                System.out.print("Select an option:");
                option = sc.nextInt();

                if (option == 5)
                    mainMenu();

                //error msg
                if (option > 5 || option < 0) {
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>PLEASE ENTER AVAILABLE SELECTION<ERROR>" + ConsoleColors.RESET);
                }
            } while (option > 5 || option < 0);

            for (int i = 0; i < sportCourtReservation.courtDetail.length; i++) {
                for (int j = 0; j < courtDetail[i].length; j++) {
                    if (option == 1) {
                        if (courtDetail[i][j].getDate() == today) {
                            if (j == 0) {
                                System.out.println(courtDetail[i][j].toStringCourtDetailAndTime());
                            }
                            System.out.print(courtDetail[i][j].toStringTimeSlot());
                            if (courtDetail[i][j].getTimeOutHour() == time[5]) {
                                System.out.println("\n+---------+---------+---------+---------+---------+");
                                System.out.println("\n|/////////| = booked");
                            }
                        }
                    } else if (option == 2) {
                        if (courtDetail[i][j].getDate() == nextDate) {
                            if (j == 0) {
                                System.out.println(courtDetail[i][j].toStringCourtDetailAndTime());
                            }
                            System.out.print(courtDetail[i][j].toStringTimeSlot());
                            if (courtDetail[i][j].getTimeOutHour() == time[5]) {
                                System.out.println("\n+---------+---------+---------+---------+---------+");
                                System.out.println("\n|/////////| = booked");
                            }
                        }
                    } else if (option == 3) {
                        if (courtDetail[i][j].getDate() == next2Date) {
                            if (j == 0) {
                                System.out.println(courtDetail[i][j].toStringCourtDetailAndTime());
                            }
                            System.out.print(courtDetail[i][j].toStringTimeSlot());
                            if (courtDetail[i][j].getTimeOutHour() == time[5]) {
                                System.out.println("\n+---------+---------+---------+---------+---------+");
                                System.out.println("\n|/////////| = booked");
                            }
                        }
                    } else if (option == 4) {
                        if (j == 0) {
                            System.out.println(courtDetail[i][j].toStringCourtDetailAndTime());
                        }
                        System.out.print(courtDetail[i][j].toStringTimeSlot());
                        if (courtDetail[i][j].getTimeOutHour() == time[5]) {
                            System.out.println("\n+---------+---------+---------+---------+---------+");
                            System.out.println("\n|/////////| = booked");
                        }
                    } else {
                        break;
                    }
                }
            }
            promptAnyKey();
        } while (option != 5);
        sc.close();
    }

    // book court (no 2)
    public static void bookCourt() {
        Scanner sc = new Scanner(System.in);
        
        int chooseDate;
        Date dateChosen=today;
        int chooseLocation;
        String locat = "";
        int timeChosen;
        int[] startTimeHr = new int[5];
        int[] endTimeHr = new int[5];
        int startHr = 0;
        int endHr = 0;

        //booking court
        do {
            sportCourt.no = 0;
            do {
                System.out.println("\n\n+---------------------------------------------------------+");
                System.out.println("|                          COURT                          |");
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|                      1."+today.toString()+"                       |");
                System.out.println("|                      2."+nextDate.toString()+"                       |");
                System.out.println("|                      3."+next2Date.toString()+"                       |");
                System.out.println("|                         4.BACK                          |");
                System.out.println("+---------------------------------------------------------+");

                do {
                    System.out.print("Please select a type of court:");
                    chooseDate = sc.nextInt();

                    switch (chooseDate) {
                        case 1:
                            dateChosen = today;
                            break;
                        case 2:
                            dateChosen = nextDate;
                            break;
                        case 3:
                            dateChosen = next2Date;
                            break;
                        case 4:
                            mainMenu();
                            break;
                    }
                    if (chooseDate > 4 || chooseDate < 0) {
                        System.out.println(ConsoleColors.RED_BOLD + "<ERROR>PLEASE ENTER AVAILABLE SELECTION<ERROR>" + ConsoleColors.RESET);
                    }
                } while (chooseDate > 4 || chooseDate < 0);
                System.out.println("\n\n\tDate:" + dateChosen);
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|                         LOCATION                        |");
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|                      1.KUALA LUMPUR                     |");
                System.out.println("|                        2.PAHANG                         |");
                System.out.println("|                         3.BACK                          |");
                System.out.println("+---------------------------------------------------------+");
                do {
                    System.out.print("Please select a location:");
                    chooseLocation = sc.nextInt();
                    switch (chooseLocation) {
                        case 1:
                            locat = "Kuala Lumpur";
                            break;
                        case 2:
                            locat = "Pahang";
                            break;
                    }
                    if (chooseLocation > 3 || chooseLocation < 0) {
                        System.out.println(ConsoleColors.RED_BOLD + "<ERROR>PLEASE ENTER AVAILABLE SELECTION<ERROR>" + ConsoleColors.RESET);
                    }
                } while (chooseLocation > 3 || chooseLocation < 0);
            } while (chooseLocation == 3);
            System.out.println("\n\n\tDate:" + dateChosen + "\t\tLocation:" + locat);
            System.out.println("+---------------------------------------------------------+");
            System.out.println("|                           TIME                          |");
            System.out.println("+---------------------------------------------------------+");
            for (int i = 0; i < courtDetail.length; i++) {
                for (int j = 0; j < courtDetail[i].length; j++) {
                    if (courtDetail[i][j].getStatus() == SportCourtStatus.Available) {
                        if (courtDetail[i][j].getDate() == dateChosen && courtDetail[i][j].location.getState() == locat) {
                            System.out.println(courtDetail[i][j].toStringTime());
                            startTimeHr[j] = courtDetail[i][j].getTimeInHour();
                            endTimeHr[j] = courtDetail[i][j].getTimeOutHour();
                        }
                    }
                }
            }

            sportCourt.no++;
            System.out.println("|                  " + sportCourt.no + ".BACK TO SELECT COURT                 |");
            System.out.println("+---------------------------------------------------------+");
            do {
                System.out.print("Please select a time:");
                timeChosen = sc.nextInt();
                if (timeChosen > sportCourt.no || timeChosen < 0) {
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>PLEASE ENTER AVAILABLE SELECTION<ERROR>" + ConsoleColors.RESET);
                }
            } while (timeChosen > sportCourt.no || timeChosen < 0);
        } while (timeChosen == sportCourt.no);
        int len = 0;
        for (int i = 0; i < startTimeHr.length; i++) {
            if (startTimeHr[i] != 0)
                len++;
        }
        int[] newStartTimeHr = new int[len];
        int[] newEndTimeHr = new int[len];
        for (int i = 0, j = 0; i < startTimeHr.length; i++) {
            if (startTimeHr[i] != 0) {
                newStartTimeHr[j] = startTimeHr[i];
                newEndTimeHr[j] = endTimeHr[i];
                j++;
            }
        }
        for (int i = 0; i <= newStartTimeHr.length; i++) {
            if (timeChosen == i) {
                startHr = newStartTimeHr[i - 1];
                endHr = newEndTimeHr[i - 1];
                break;
            }
        }
        
        double charge = 0;
        String courtCode = "";
        String courtName = "";
        for (int i = 0; i < courtDetail.length; i++) {
            for (int j = 0; j < courtDetail[i].length; j++) {
                if (courtDetail[i][j].getStatus() == SportCourtStatus.Available) {
                    if (courtDetail[i][j].getDate() == dateChosen && courtDetail[i][j].location.getState() == locat && courtDetail[i][j].getTimeInHour() == startHr && courtDetail[i][j].getTimeOutHour() == endHr) {
                        courtCode = courtDetail[i][j].getCourtCode();
                        courtName = courtDetail[i][j].name;
                        courtDetail[i][j].setStatus(SportCourtStatus.Reserved);
                        charge = courtDetail[i][j].getCharge();

                    }
                }
            }
        }
        int countI = 0;
        int j=0;
        for (int i = 0; i < booking.length; i++) {
            if (booking[i][0].getUser_id() == null) {
                for (j = 0; j < booking[i].length; j++) {
                    if (booking[i][j].getUser_id() == null) {
                        countI = i;
                        booking[countI][j] = new Booking(today,dateChosen, id, courtCode, courtName, startHr, endHr,charge,ReservationStatus.Pending);
                        payment.addCourtBooked(booking[countI][j]);
                        break;
                    }
                }
                break;
            } else if (booking[i][0].getUser_id().equals(id)) {
                for (j = 0; j < booking[i].length; j++) {
                    if (booking[i][j].getUser_id() == null) {
                        countI = i;
                        booking[countI][j] = new Booking(today,dateChosen, id, courtCode, courtName, startHr, endHr,charge,ReservationStatus.Pending);
                        payment.addCourtBooked(booking[countI][j]);
                        break;
                    }
                }
                break;
            }
        }
        countBooking++;
        System.out.println("\n\n=================================");
        System.out.println("         Booking  Detail         ");
        System.out.println("=================================");
        System.out.println(booking[countI][j].toString());
        promptAnyKey();
        mainMenu();
        sc.close();
    }

    // order drinks (no 3)
    public static void orderDrinks() {
        Scanner in = new Scanner(System.in);

        Beverage[] drinksType = {
                new Beverage("Water",2.0),
                new Beverage("Apple Juice",6.50),
                new Beverage("Orange Juice",7.50),
                new Beverage("Pineapple Juice",8.70),
                new Beverage("Lucozade Energy",12.0),
                new Beverage("Powerade Zero",14.0),
        };

        Beverage drink;


        final String[] drinks = {"Water","Apple Juice","Orange Juice","Pineapple Juice","Lucozade Energy","Powerade Zero"};
        int option;
        do {
            System.out.println("\n+-----------------------------------------------------------+");
            System.out.println("|           Bottled Drinks          |        Price          |");
            System.out.println("+-----------------------------------+-----------------------+");
            for (int i = 0; i < drinksType.length; i++) {
                System.out.println("|     " + (i+1) + "." + drinksType[i].toStringDrinksSell());
            }
            System.out.println("+-----------------------------------------------------------+");
            System.out.println("|                   7. BACK TO MAIN MENU                    |");
            System.out.println("+-----------------------------------------------------------+");

            while (true) {
                System.out.print("Please enter an option: ");
                option = in.nextInt();
                if (option >= 1 && option <= 7)
                    break;
                System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter number between 1 and 7 only.<ERROR>" + ConsoleColors.RESET);
            }

            if(option == 7)
                mainMenu();

            int quantity;
            System.out.print("Please enter quantity: ");
            quantity = in.nextInt();

            drink = new Beverage(drinksType[option-1].getDrinksName(), drinksType[option-1].getPrice(),quantity);
            payment.addBeverageOrder(drink);
            System.out.println(ConsoleColors.WHITE_BOLD + "Added to payment." + ConsoleColors.RESET);



        }while(option != 7);

    }

    // membership (no 4)
    public static void membership(){
        Scanner in = new Scanner(System.in);

        Member[] memberType = {
                new Member("BASIC",1,35,3.0),
                new Member("STANDARD",1,50,6.0),
                new Member("PREMIUM",1,75,10.0)
        };

        int option;
        do {
            System.out.println("+------------------------------------+");
            System.out.println("|              MEMBERSHIP            |");
            System.out.println("+------------------------------------+");
            System.out.println("|        1. BASIC                    |");
            System.out.println("|        2. STANDARD                 |");
            System.out.println("|        3. PREMIUM                  |");
            System.out.println("|        4. BACK                     |");
            System.out.println("+------------------------------------+");
            while (true) {
                System.out.print("\nPlease enter an option: ");
                option = in.nextInt();
                if (option >= 1 && option <= 4)
                    break;
                System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter number between 1 to 3 only.<ERROR>" + ConsoleColors.RESET);
            }

            if (option == 4)
                mainMenu();


                    if(cus[count].getMembership().getType() == null){ // means don't have membership
                        System.out.println(memberType[option - 1].toStringMemberTypeSell());
                        char yesNo;
                        while (true) {
                            System.out.print("\nConfirm to buy " + memberType[option - 1].getType() + " membership(Y = Yes , N = No)? ");
                            yesNo = in.next().charAt(0);
                            if(Character.toUpperCase(yesNo) == 'Y' || Character.toUpperCase(yesNo) == 'N')
                                break;
                            System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter 'Y' or 'N' only.<ERROR>" + ConsoleColors.RESET);
                        }

                        if(Character.toUpperCase(yesNo) == 'Y'){
                            System.out.println(ConsoleColors.WHITE_BOLD + "Added to payment." + ConsoleColors.RESET);
                            cus[count].setMembership(memberType[option - 1]);
                            payment.addAmount(memberType[option - 1].getPrice());
                            payment.setDISCOUNT(((memberType[option - 1].getDiscount()) / (double)100 ));
                            cus[count].getMembership().setBuyNow(true);
                        }


                    }else{
                        System.out.println(ConsoleColors.WHITE_BOLD + "You already have membership/You have booked a membership." + ConsoleColors.RESET);
                    }



        }while(option != 4);

    }

    //user profile (no 5)
    public static void userProfile(){
        Scanner sc = new Scanner(System.in);
        String re_user_id;
        while(true){
            System.out.print("Please Re-Enter Your User Id : ");
            re_user_id = sc.nextLine();
            if(re_user_id.equals(cus[count].getId()))
            {
                cus[count].displayCustDetail();
                break;
            }
            System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please Enter Valid Id <ERROR>" + ConsoleColors.RESET);

        }


        String yy;

        do {
            System.out.print("\nDo You Want To Modify Your Details (Type Y To Modify || N To Exit )? >>>>>> ");
            yy = sc.nextLine();

            if (yy.equals("y")) {
                System.out.println("===================================================");
                System.out.println("Please Select Which Details You Want To Modify : ");
                System.out.println("===================================================");
                System.out.println("1. User Id ");
                System.out.println("2. Password");
                System.out.println("3. Name");
                System.out.println("4. Email");
                System.out.println("5. Phone");

                System.out.println("6. Street Address");
                System.out.println("7. City ");
                System.out.println("8. State ");
                System.out.println("9. Post Code ");
                System.out.println("===================================================");
                int another_selection = sc.nextInt();
                sc.nextLine();

                switch (another_selection) {

                    case 1:
                        System.out.println("===================================================");
                        System.out.print("Please Enter New User Id : ");
                        String modify_id = sc.nextLine();
                        cus[count].setUser_id(modify_id);
                        System.out.println("===================================================");


                        break;
                    case 2:
                        System.out.println("===================================================");
                        System.out.print("Please Enter  New Password : ");
                        String modify_pass = sc.nextLine();
                        cus[count].setPassword(modify_pass);
                        System.out.println("===================================================");

                        break;

                    case 3:
                        System.out.println("===================================================");
                        System.out.println("Please Enter Your New Name : ");
                        String modify_name = sc.nextLine();
                        cus[count].getPerson().setName(modify_name);
                        System.out.println("===================================================");

                        break;

                    case 4:
                        String modify_email;
                        System.out.println("===================================================");

                        while (true) {
                            System.out.print("Please Enter Your Email Address (include '@' ): ");
                            modify_email = sc.nextLine();
                            if (Pattern.matches("^(.+)@(.+)$", modify_email))
                                break;
                            System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter a valid email address(exp: xxx@gmail.com).<ERROR>" + ConsoleColors.RESET);

                        }
                        cus[count].getPerson().setEmail(modify_email);
                        System.out.println("===================================================");

                        break;

                    case 5:
                        String modify_phone;
                        System.out.println("===================================================");
                        while (true) {
                            System.out.print("Please Enter Phone Number(include '-' ): ");
                            modify_phone = sc.next();
                            if (Pattern.matches("[0-9]{3}-[0-9]{7,8}", modify_phone))
                                break;
                            System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter a valid phone number(exp: 011-12345678).<ERROR>" + ConsoleColors.RESET);
                        }

                        cus[count].getPerson().setPhone(modify_phone);
                        System.out.println("===================================================");
                        break;



                    case 6:
                        System.out.println("===================================================");
                        System.out.print("Please Enter New Street Address : ");
                        String modify_street = sc.nextLine();
                        cus[count].getPerson().getAddress().setStreetAddress(modify_street);
                        System.out.println("===================================================");

                        break;
                    case 7:
                        System.out.println("===================================================");
                        System.out.print("Please Enter New City :");
                        String modify_city = sc.nextLine();
                        cus[count].getPerson().getAddress().setCity(modify_city);
                        System.out.println("===================================================");

                        break;
                    case 8:
                        System.out.println("===================================================");
                        System.out.print("Please Enter New State : ");
                        String modify_state = sc.nextLine();
                        cus[count].getPerson().getAddress().setState(modify_state);
                        System.out.println("===================================================");

                        break;

                    case 9:
                        System.out.println("===================================================");
                        System.out.println("Please Enter New Post Code : ");
                        int modify_post_code = sc.nextInt();
                        cus[count].getPerson().getAddress().setPostCode(modify_post_code);
                        System.out.println("===================================================");
                }


            } else if (yy.equals("n")) {
                mainMenu();
            } else {
                System.out.println("Please Enter 'Y' Or 'N' Only");
            }


        }while (yy == "y" || yy == "Y");

    }

    // my booking (no 6)
    public static void bookingList(){
        Scanner sc = new Scanner(System.in);
        
        int countOldDate=0;
        int removeOption=0;
        int option;
        int no;
        int countI=99;
        int countJ=99;
        for(int i=0;i<booking.length;i++){
            if(booking[i][0].getUser_id()==null){
                break;
            }else if (booking[i][0].getUser_id().equals(id)){
                for (int j = 0; j < booking[i].length; j++) {
                    if (booking[i][j].getUser_id() == null) {
                        countI=i;
                        countJ=j;
                        break;
                    }
                }
                break;
            }
        }
        if(countI!=99){
            for(int i=0;i<booking[countI].length;i++){
                if(booking[countI][i].getReservationDate()!=today&&booking[countI][i].getReservationDate()!=nextDate&&booking[countI][i].getReservationDate()!=next2Date&&booking[countI][i].getReservationDate()!=null)
                countOldDate++;
            }
        }
        do {
            no=0;
            while (true) {
                System.out.println("\n\n+---------------------------------------------------------+");
                System.out.println("|                        My Booking                       |");
                System.out.println("+---------------------------------------------------------+");
                System.out.println("|                     1.Booking List                      |");
                System.out.println("|                     2.Current Booking                   |");
                System.out.println("|                     3.Remove Booking                    |");
                System.out.println("|                     4.Back                              |");
                System.out.println("+---------------------------------------------------------+");
                System.out.print("Please select an option:");
                option = sc.nextInt();
                if (option >= 1 && option <= 4)
                    break;
                System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter number between 1 and 4 only<ERROR>" + ConsoleColors.RESET);
            }
            if (option == 1) {
                System.out.println("\n\n+------------------------------------------------------------------------------------------------------+");
                System.out.println("|                                             BOOKING LIST                                             |");
                System.out.println("+------------------------------------------------------------------------------------------------------+");
                System.out.println("|No.|  BOOKING DATE  | RESERVATION DATE |   COURT CODE   |  TIME IN  |  TIME OUT  | RESERVATION STATUS |");
                System.out.println("+---+----------------+------------------+----------------+-----------+------------+--------------------+");
                if(countI!=99){
                for (int j = 0; j < countJ; j++) {
                    no++;
                    System.out.print("| "+no+".");
                    System.out.println(booking[countI][j].toStringBookingList());
                }}
                if(no!=0)
                    System.out.println("+---+----------------+------------------+----------------+-----------+------------+--------------------+");
                else if(no == 0)
                    System.out.println(ConsoleColors.WHITE_BOLD + "YOU HAVEN'T BOOK ANY COURT" + ConsoleColors.RESET);
                promptAnyKey();
            } else if (option == 2) {
                System.out.println("\n\n+---------------------------------------------------------------------------------+");
                System.out.println("|                                 CURRENT BOOKING                                 |");
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.println("|No.|     DATE     |   COURT CODE   |  TIME IN  |  TIME OUT  | RESERVATION STATUS |");
                System.out.println("+---+--------------+----------------+-----------+------------+--------------------+");
                if(countI!=99){
                for(int j=0;j<countJ;j++){
                    if(booking[countI][j].getReservationDate()==today||booking[countI][j].getReservationDate()==nextDate||booking[countI][j].getReservationDate()==next2Date){
                        no++;
                        System.out.print("| "+no+".");
                        System.out.println(booking[countI][j].toStringListStatus());
                    }
                }}
                if(no!=0)
                    System.out.println("+---+--------------+----------------+-----------+------------+--------------------+");
                else if(no == 0)
                    System.out.println(ConsoleColors.WHITE_BOLD + "CURRENT HAVEN'T ANY BOOKING" + ConsoleColors.RESET);
                promptAnyKey();
            } else if (option==3){
                do{
                    no=0;
                    System.out.println("\n\n+------------------------------------------------------------+");
                    System.out.println("|                       REMOVE BOOKING                       |");
                    System.out.println("+------------------------------------------------------------+");
                    System.out.println("|No.|     DATE     |   COURT CODE   |  TIME IN  |  TIME OUT  |");
                    System.out.println("+---+--------------+----------------+-----------+------------+");
                
                    if(countI!=99){
                    for(int j=0;j<countJ;j++){
                        if(booking[countI][j].getStatus()==ReservationStatus.Pending){
                            no++;
                            System.out.print("| "+no+".");
                            System.out.println(booking[countI][j].toStringList());
                        }
                    }}
                    Date date;
                    if(no==0){
                        System.out.println(ConsoleColors.WHITE_BOLD + "YOU HAVEN'T BOOK ANY COURT" + ConsoleColors.RESET);
                        promptAnyKey();
                    }else{
                        no++;
                        System.out.println("| "+no+".|  REMOVE ALL                                            |");
                        no++;
                        System.out.println("| "+no+".|  BACK TO MY BOOKING                                    |");
                        System.out.println("+---+--------------+----------------+-----------+------------+");
                        System.out.print("\nEnter a booking to remove:");
                        removeOption = sc.nextInt();
                        if(removeOption!=no){
                            if(removeOption==(no-1)){
                                for(int i=0;i<countBooking;i++){
                                    booking[countI][countOldDate+i].setStatus(ReservationStatus.Cancelled);
                                    for(int k=0;k<courtDetail.length;k++){
                                        for(int l=0;l<courtDetail[k].length;l++){
                                            if(courtDetail[k][l].getCourtCode()==booking[countI][countOldDate+i].getCourtCode()&&courtDetail[k][l].getTimeInHour()==booking[countI][countOldDate+i].getTimeInHour()&&courtDetail[k][l].getDate()==booking[countI][countOldDate+i].getReservationDate()){
                                                courtDetail[k][l].setStatus(SportCourtStatus.Available);
                                            }
                                        }
                                    }   
                                }
                                payment.removeAllCourtBooked((removeOption-2));
                            }else{
                                int len = 0;
                                for (int i = 0; i < countBooking; i++) {
                                    ReservationStatus status = booking[countI][countOldDate+i].getStatus();
                                    if (status != ReservationStatus.Cancelled)
                                        len++;
                                }

                                Booking[] newBooking = new Booking[len];
                                for (int i=0,j=0;i<countBooking;i++) {
                                    if(booking[countI][countOldDate+i].getStatus()!=ReservationStatus.Cancelled){
                                        newBooking[j] = booking[countI][countOldDate+i];
                                        j++;
                                    }
                                }
                                String courtCode;
                                int hr;
                                for (int i = 0; i <= newBooking.length; i++) {
                                    if(removeOption == i) {
                                        courtCode = newBooking[i - 1].getCourtCode();
                                        hr = newBooking[i - 1].getTimeInHour();
                                        date = newBooking[i - 1].getReservationDate();
                                        for(int j=0;j<countBooking;j++){
                                            if(booking[countI][countOldDate+j].getCourtCode()==courtCode&&booking[countI][countOldDate+j].getReservationDate()==date&&booking[countI][countOldDate+j].getTimeInHour()==hr){
                                                booking[countI][countOldDate+j].setStatus(ReservationStatus.Cancelled);
                                                for(int k=0;k<courtDetail.length;k++){
                                                    for(int l=0;l<courtDetail[k].length;l++){
                                                        if(courtDetail[k][l].getCourtCode()==courtCode&&courtDetail[k][l].getTimeInHour()==hr&&courtDetail[k][l].getDate()==date){
                                                            courtDetail[k][l].setStatus(SportCourtStatus.Available);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        payment.removeCourtBooked((i-1));
                                    }
                                }
                            }
                            if(removeOption>no){
                                System.out.println(ConsoleColors.RED_BOLD + "PLEASE ENTER 1 TO "+no+" only" + ConsoleColors.RESET);
                            }else{
                                System.out.println(ConsoleColors.LIGHT_GREEN + "BOOKING REMOVED" + ConsoleColors.RESET);
                                promptAnyKey();
                            }
                        }
                    }
                }while(removeOption>no);
                
            }else
                mainMenu();
        }while (option != 4 || removeOption == no || no == 0);
        sc.close();
    }

    // my payment (no 7)
    public static void myPayment(){
        Scanner in = new Scanner(System.in);

        int countI=99;
        int countJ=99;
        for(int i=0;i<booking.length;i++){
            if(booking[i][0].getUser_id()==null){
                break;
            }else if (booking[i][0].getUser_id().equals(id)){
                for (int j = 0; j < booking[i].length; j++) {
                    if (booking[i][j].getUser_id() == null) {
                        countI=i;
                        countJ=j;
                        break;
                    }
                }
                break;
            }
        }

        PaymentTransaction transaction;


        int choose;
        int chooseMethod;
        int chooseBank;
        do{
            do {
                chooseMethod = 0;
                while (true) {
                    System.out.println("\n+--------------------------+");
                    System.out.println("|         My Payment       |");
                    System.out.println("+--------------------------+");
                    System.out.println("|   1. Make Payment        |");
                    System.out.println("|   2. Payment Details     |");
                    System.out.println("|   3. Back                |");
                    System.out.println("+--------------------------+");
                    System.out.print("\nPlease select an option: ");
                    choose = in.nextInt();
                    //validation
                    if (choose >= 1 && choose <= 3)
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter number between 1 and 3 only.<ERROR>" + ConsoleColors.RESET);
                }
                do {
                    chooseBank = 0; //  prevent infinite loop
                    if (choose == 1) {// make payment
                        if(payment.getAmount() > 0 ) {
                            if(payment.getTotalCourtBooked() != 0)
                                payment.displayBookedCourt();
                            if(payment.getTotalBeverageOrder() != 0)
                                payment.displayBeverageOrder();
                            cus[count].getMembership().displayMemberPurchase();

                            System.out.println(payment);

                            while (true) {
                                System.out.println("\n+---------------------------+");
                                System.out.println("|       Payment Method      |");
                                System.out.println("+---------------------------+");
                                System.out.println("|    1. Credit Card         |");
                                System.out.println("|    2. Online Banking      |");
                                System.out.println("|    3. Cash                |");
                                System.out.println("|    4. Back                |");
                                System.out.println("+---------------------------+");
                                System.out.print("\nPlease select an option: ");
                                chooseMethod = in.nextInt();
                                //validation
                                if (chooseMethod >= 1 && chooseMethod <= 4)
                                    break;
                                System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter number between 1 and 4 only.<ERROR>" + ConsoleColors.RESET);
                            }
                        }else {
                            System.out.println(ConsoleColors.WHITE_BOLD + "\n\t\t   No payment to pay. Go to Booking first." + ConsoleColors.RESET);
                        }
                    }

                    if (chooseMethod == 1 || chooseMethod == 2) {
                        while (true) {
                            System.out.println("\n+--------------------+");
                            System.out.println("|     Bank Name      |");
                            System.out.println("+--------------------+");
                            System.out.println("| 1. Public Bank     |");
                            System.out.println("| 2. MayBank         |");
                            System.out.println("| 3. Alliance Bank   |");
                            System.out.println("| 4. Back            |");
                            System.out.println("+--------------------+");
                            System.out.print("\nPlease select an option: ");
                            chooseBank = in.nextInt();
                            //validation
                            if (chooseBank >= 1 && chooseBank <= 4)
                                break;
                            System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter number between 1 and 4 only.<ERROR>" + ConsoleColors.RESET);
                        }
                    }
                }while(chooseBank == 4);
            }while(chooseMethod == 4);

            String[] transactionType = {"Credit Card", "Online Banking", "Cash"};
            String[] bankName = {"Public Bank", "MayBank", "Alliance Bank"};
            if(chooseMethod == 1){
                in.nextLine();
                String nameOnCard;
                while(true) {
                    System.out.print("\nPlease enter name on card: ");
                    nameOnCard = in.nextLine();
                    //validation
                    if(Pattern.matches("[a-zA-Z ]{5,}",nameOnCard))
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter character only.(at least 5 character)<ERROR>" + ConsoleColors.RESET);
                }

                String cardNo;
                while(true) {
                    System.out.print("\nPlease enter 16 digit Credit Card No(include '-' ): ");
                    cardNo = in.nextLine();
                    if(Pattern.matches("[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}",cardNo))
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter a valid Credit Card No(exp:1111-1111-1111-1111).<ERROR>" + ConsoleColors.RESET);
                }
                String pinNum;
                while(true) {
                    System.out.print("\nPlease enter 6 digit PIN number: ");
                    pinNum = in.nextLine();
                    if(Pattern.matches("[0-9]{6}",pinNum))
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter exactly 6 digit for PIN number.<ERROR>" + ConsoleColors.RESET);
                }
                System.out.println(ConsoleColors.LIGHT_GREEN + "Payment Successfully" + ConsoleColors.RESET);

                transaction = new CreditCard(transactionType[chooseMethod - 1], bankName[chooseBank - 1], nameOnCard, cardNo, pinNum);
                payment.setTransaction(transaction);

                if(payment.getTotalCourtBooked() > 0) {
                    for (int j = 0; j < countJ; j++) {
                        if (booking[countI][j].getStatus() == ReservationStatus.Pending) {
                            booking[countI][j].setStatus(ReservationStatus.Completed);
                        }
                    }
                }

            }else if(chooseMethod == 2){
                in.nextLine();
                String onlineBankingAccID;
                while(true) {
                    System.out.print("\nPlease enter Online Banking Account ID: ");
                    onlineBankingAccID = in.nextLine();
                    if(Pattern.matches("\\w{6,}", onlineBankingAccID)) // \w = [a-zA-Z0-9]
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter alphabet or digit only with the length of account ID more than 5.<ERROR>" + ConsoleColors.RESET);
                }

                String onlineBankingPassword;
                while(true) {
                    System.out.print("\nPlease enter password: ");
                    onlineBankingPassword = in.nextLine();
                    if(Pattern.matches("\\w{6,}", onlineBankingPassword))
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter alphabet or digit only with the length of PASSWORD more than 5.<ERROR>" + ConsoleColors.RESET);
                }
                System.out.println(ConsoleColors.LIGHT_GREEN + "Login Successfully" + ConsoleColors.RESET);

                String reference;
                while(true) {
                    System.out.print("\nPlease enter Recipient's reference: ");
                    reference = in.nextLine();
                    if(Pattern.matches("\\w{3,}",reference))
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter alphabet or digit only with the length of reference more than 2.<ERROR>" + ConsoleColors.RESET);
                }

                String pacNo;
                while(true) {
                    System.out.print("\nPlease enter PAC NO that send to your phone(6 digit): ");
                    pacNo = in.nextLine();
                    if(Pattern.matches("[0-9]{6}",pacNo))
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>Please enter exactly 6 digit for PAC No.<ERROR>" + ConsoleColors.RESET);
                }
                System.out.println(ConsoleColors.LIGHT_GREEN + "Payment Successfully" + ConsoleColors.RESET);

                transaction = new OnlineBanking(transactionType[chooseMethod - 1], bankName[chooseBank - 1], onlineBankingAccID, onlineBankingPassword, reference, pacNo);
                payment.setTransaction(transaction);

                if(payment.getTotalCourtBooked() > 0) {
                    for (int j = 0; j < countJ; j++) {
                        if (booking[countI][j].getStatus() == ReservationStatus.Pending) {
                            booking[countI][j].setStatus(ReservationStatus.Completed);
                        }
                    }
                }


            }else if(chooseMethod == 3){
                double cashTendered;
                while (true) {
                    System.out.print("\nPlease enter cash tendered: RM ");
                    cashTendered = in.nextDouble();
                    if (payment.calculatePayment() < cashTendered)
                        break;
                    System.out.println(ConsoleColors.RED_BOLD + "<ERROR>There is insufficient cash for tenders<ERROR>" + ConsoleColors.RESET);
                }

                System.out.println(ConsoleColors.LIGHT_GREEN + "Payment Successfully" + ConsoleColors.RESET);

                transaction = new Cash(transactionType[chooseMethod - 1], " - ", cashTendered, (cashTendered - payment.calculatePayment()));
                payment.setTransaction(transaction);

                if(payment.getTotalCourtBooked() > 0) {
                    for (int j = 0; j < countJ; j++) {
                        if (booking[countI][j].getStatus() == ReservationStatus.Pending) {
                            booking[countI][j].setStatus(ReservationStatus.Completed);
                        }
                    }
                }

            }

            if(payment.getTransaction() != null && (payment.getAmount() > 0)){
                //receipt

                System.out.print(payment.getTransaction());
                if(cus[count].getMembership().getType() != null)
                    System.out.print(cus[count].getMembership().toStringMember());
                if(payment.getTotalCourtBooked() != 0)
                    payment.displayBookedCourt();
                if(payment.getTotalBeverageOrder() != 0)
                    payment.displayBeverageOrder();
                System.out.println(payment);
                payment.getTransaction().displayDetail();

                payment = new Payment(new Booking[15],new Beverage[10],0,0,0,((cus[count].getMembership().getDiscount()) / (double)100));
                promptAnyKey();
            }

            if(choose == 2) { // payment details
                if(payment.getAmount() > 0 )  {
                    if(payment.getTotalCourtBooked() != 0)
                        payment.displayBookedCourt();
                    if(payment.getTotalBeverageOrder() != 0)
                        payment.displayBeverageOrder();
                    cus[count].getMembership().displayMemberPurchase();

                    System.out.println(payment);

                } else {
                    System.out.println(ConsoleColors.WHITE_BOLD + "\n\t\t   No payment details. Go to Booking first." + ConsoleColors.RESET);
                }

            }else if(choose == 3)
                mainMenu();

        }while(choose != 3);
        in.close();
    }

    public static void promptAnyKey(){
        System.out.println("\nPress \"Enter\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}



