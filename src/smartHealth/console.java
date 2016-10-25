package smartHealth;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class console {
/*	
	
	
	
public static void main(String args[])
{
	int i=0;
	int j=0;
	boolean flag=true;
	//String username=null;
	String phone=null;
	//String password=null;
	Database dbase = new Database();
	HealthDataDb hdata=new HealthDataDb();
	Scanner s=new Scanner(System.in);
    Simulator sim= new Simulator();
    hdata.getLastDatumID();
    while(true){
	System.out.println("\n 1: Registration" + "\n 2: Login"+ "\n 3: Exit");
	//System.out.println("Press 1 for new user registration \nPress 2 for existing user login\nPress 0 for exit");
	 i=s.nextInt();
	 switch(i){
	 case 1: //registration
		 System.out.println("Enter the details : \n");
		 sim.userName();
	/* while(flag==true){
	 System.out.println("Enter Username");
	 username=s.next();
		flag=dbase.checkUsername(username);
		if(flag==true){
		System.out.print("Please  try some other user name.This user name already exists");
	 }
		
	 }
	 sim.pWord();
	 sim.allOtherDetails();
	 /*flag=true;
	 while(flag==true){
		System.out.println("Enter Password");
		
		password=s.next();
		flag=dbase.checkPassword(password);
		if(flag==true){
			System.out.print("Please  try some other password.");
		 }
		 }
	 flag=true;
	 String email1=null;
	 String email2=null;
			while(flag==true)
		{System.out.println("Enter email1");
		 email1=s.next();
		System.out.println("Enter email2");
	    email2=s.next();
		if(email1.equals(email2))
		{
			System.out.println("Both should not be same");
		}
		else
		{
			flag=false;
		}
		}
		System.out.println("Enter firstname");
		String firstname=s.next();
		System.out.println("Enter lastname");
		String lastname=s.next();
		System.out.println("Enter aboutme");
		String aboutme=s.next();
		System.out.println("Enter photo1");
		String pic1=s.next();
		System.out.println("Enter photo2");
		String pic2=s.next();
		System.out.println("Enter photo3");
		String pic3=s.next();
		System.out.println("Enter streetno");
		String streetno=s.next();
		System.out.println("Enter sreetname");
		String streetname=s.next();
		System.out.println("Enter municipality");
		String mun=s.next();
		System.out.println("Enter district");
		String dis=s.next();
		System.out.println("Enter postalarea");
		String postal=s.next(); 
	   
	     System.out.println("\n 1: Moderator" + "\n 2: Admin"+ "\n 3: End User");
		 
	     j=s.nextInt();
		 if(j==1){
		  System.out.println("--Moderator--");
		  //sim.phone();
		  while(flag==true){
		  System.out.println("Enter Phone");
			phone=s.next();
			flag=dbase.checkPhone(phone);
			if(flag==true){
				System.out.print("Please enter a valid phone number.");
			 }
		  }
		  sim.moderator();
		 /* Moderator moduser=new Moderator(username, password,firstname,  lastname,  email1,email2, pic1, pic2,pic3, aboutme,
					streetname, streetno, postal,  mun, "new", dis,phone);
		 dbase.addModeratorToDatabase(moduser);
	
		 dbase.showQualifications();
		 int id=s.nextInt();
		 dbase.addModeratorQualificationToDatabase(moduser, id);
		  
		 }
		 
		if(j==2){
			System.out.println("--Admin--");
			sim.phone();
			 /*while(flag==true){
			System.out.println("Enter Phone");
			phone=s.next();
			flag=dbase.checkPhone(phone);
			if(flag==true){
				System.out.print("Please enter a valid phone number.");
			 }
			 }
			Admin aduser=new Admin(username, password,firstname,  lastname,  email1,
					email2, pic1, pic2,pic3,aboutme, phone,
					streetname,streetno, postal,  mun,"new", dis);
			dbase.addAdminToDatabase(aduser);
			sim.admin();
		}
		
		if (j==3){
			System.out.println("--End User--");
			sim.endUser();
			/*EndUser euser=new EndUser(username, password,firstname,  lastname,  email1,
		
					email2, pic1, pic2,pic3,aboutme,
					streetname,streetno, postal,  mun,"new", dis);
			
			dbase.addEndUserToDatabase(euser);
		}
		
		break;
		
	 case 2: //login for those users who already have a profile created
		 System.out.println("--Login--");
		     
	         System.out.println("Enter Username");
	         String Uname=s.next();
	         System.out.println("Enter Password");
	         String pwd=s.next();
	         dbase.loginCheck(Uname, pwd);
	         System.out.println("You have successfully logged in !");
	         int lg=1;
	         int jk=1;
	         while(jk!=9)
	         {
	         System.out.println("\n1: View Profile "+"\n2: Update Profile"+"\n3: Send Friend Request"+"\n4: View Friends"+"\n5: View Friend Requests"+"\n 6:Delete Profile"+ "\n7: Health Data"+ "\n8: Forum"+ "\n9: Log out");
	         jk=s.nextInt();
	         Friendship fship;
	         if (jk==1){
	        System.out.println("---View Profile---"); 
	        dbase.viewUserProfile(Uname);
	   
	         }
	         
	         if(jk==2){
	         System.out.println("---Update Profile---");
	         sim.updateProfile(Uname);
	        /* System.out.println("Select the field you want to update:   \n"+"\n 1: password"+"\n 2: email2"+"\n"
	         		+ " 3: pic1"+"\n 4: pic2"+"\n 5: pic3"+"\n 6: about me!"+"\n 7: first name"+"\n 8: last name"
	        		 +"\n 9: street name"+"\n 10: street number"+"\n 11: major municipality"+"\n 12: district"+"\n "
	        		 		+ "13: postal area"+"\n 14: phone" );
	         int k=0;
	         k=s.nextInt();
	         if(k==1){
	        	 System.out.println("Enter new password");
	        	 String newpwd=s.next();
	        	 dbase.updatePassword(Uname,newpwd);
	         }
	         
	         if(k==2){
	        	 System.out.println("Enter new email");
	        	 String newemail=s.next();
	        	 dbase.updateEmail2(Uname,newemail);
	         }
	         
	         if(k==3){
	        	 System.out.println("Enter new pic1");
	        	 String newpic1=s.next();
	        	 dbase.updatePic1(Uname, newpic1); 
	        	 
	         }
	         
	         if(k==4){
	        	 System.out.println("Enter new pic2");
	        	 String newpic2=s.next();
	        	 dbase.updatePic2(Uname, newpic2); 
	        	 
	         }
	         
	         if(k==5){
	        	 System.out.println("Enter new pic3");
	        	 String newpic3=s.next();
	        	 dbase.updatePic3(Uname, newpic3); 
	        	 
	         }
	         
	         if(k==6){
	        	 System.out.println("Enter new about me");
	        	 String newaboutme=s.next();
	        	 dbase.updateAboutMe(Uname, newaboutme); 
	        	 
	         }
	         
	         if(k==7){
	        	 System.out.println("Enter new first name");
	        	 String newfname=s.next();
	        	 dbase.updateFirstName(Uname, newfname); 
	        	 
	         }
	         
	         if(k==8){
	        	 System.out.println("Enter new last name");
	        	 String newlname=s.next();
	        	 dbase.updateLastName(Uname, newlname); 
	        	 
	         }
	         
	         if(k==9){
	        	 System.out.println("Enter new street name");
	        	 String newstname=s.next();
	        	 dbase.updateStreetName(Uname, newstname); 
	        	 
	         }
	         
	         if(k==10){
	        	 System.out.println("Enter new street number");
	        	 String newstnum=s.next();
	        	 dbase.updateStreetNumber(Uname, newstnum); 
	        	 
	         }
	         
	         if(k==11){
	        	 System.out.println("Enter new major municipality");
	        	 String newmm=s.next();
	        	 dbase.updateMajorMunicipalitity(Uname, newmm); 
	        	 
	         }
	         
	         if(k==12){
	        	 System.out.println("Enter new postal area");
	        	 String newpa=s.next();
	        	 dbase.updatePostalArea(Uname, newpa); 
	        	 
	         }
	         
	         if(k==13){
	        	 System.out.println("Enter new district");
	        	 String newdis=s.next();
	        	 dbase.updateDistrict(Uname, newdis); 
	        	 
	         }
	         
	         if(k==14){
	        	 System.out.println("Enter new phone");
	        	 String newphn=s.next();
	        	 dbase.updatePhone(Uname, newphn); 
	        	 
	         }
	          }
	         
	         if(jk==3){
	        	 dbase.displayUsers();
	        	 System.out.println("Send friend request");
	        	 System.out.println("Enter username of friend");
	        	 String friend=s.next();
	        	  fship=new Friendship(Uname,friend);
	        	 dbase.addFriendRequesttoDatabase(fship);
	          }
	         
	         if(jk==4){
	        	 System.out.println("View Friends");
	        	 dbase.getFriends(Uname);
	        	 System.out.println("Press 1 to unfriend 2 to continue");
	        	 int uf=s.nextInt();
	        	 if(uf==1)
	        	 {
	        		 System.out.println("Enter username of friend");
	        		 String x=s.next();
	        		 dbase.unFriend(Uname, x);
	        	 }
	        	 
	         }
	         
	         if(jk==5){
	        	 System.out.println("View Friend Request");
	        	 dbase.getFriendRequest(Uname);
	        	 System.out.println("Press 1 to accept, 2 to reject");
	        	 int a=s.nextInt();
	        	 if(a==1)
	        	 {
	        		 System.out.println("Enter the username you want to accept");
	        		 String fname=s.next();
	        		 dbase.acceptFriendRequest(Uname, fname);
	        	 }
	        	 if(a==2)
	        	 {
	        		 System.out.println("Enter the username you want to reject");
	        		 String fname=s.next();
	        		 dbase.acceptFriendRequest(Uname, fname);
	        	 }
	        	 		
	         }
	         
	         if(jk==6){
	        	 System.out.println("Delete Profile"); 
	        	 dbase.updateStatus(Uname);
	         }
	         if(jk==7){
	        	 System.out.println("--Health Data--");
	        	 sim.healthData(Uname);
	         }
	         
	         if(jk==8){
	        	 System.out.println("--Forum--");
	        	 sim.forum(Uname);
	         }
	         if(jk==9)
	         {
	        	 jk=0;
	        	 j=0;
	        	 break;
	         }
	         }
	         break;
	 case 3://exit from the system
		 System.out.println("---Exit---")    ;
	       System.exit(0);;
	 }
	 
	 }
		
		
		*/
		
		

	
}

