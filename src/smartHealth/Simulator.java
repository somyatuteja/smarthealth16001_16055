package smartHealth;

import java.util.Scanner;

public class Simulator {
 
	boolean flag=true;
	Database dbase = new Database();
	HealthDataDb hdbase= new HealthDataDb();
    ForumDatabase fdbase=new ForumDatabase();
	Scanner s=new Scanner(System.in);
	Scanner h=new Scanner(System.in);
	Scanner f=new Scanner(System.in);
	Scanner r=new Scanner(System.in);
	String username=null;
	String phone=null;
	String password=null;
	String firstname=null;
	String lastname= null;
	String aboutme= null;
    String pic1= null;
	String pic2=null;
	
	String pic3=null;
    String email1=null;
    String email2=null;
	String streetno=null;
	
	String streetname=null;
	
	String mun=null;

	String dis=null;

	String postal=null;
	  int opinion=0;
	  
	
void userName(){
		while(flag==true){
			 System.out.println("Enter Username");
			 username=s.next();
				flag=dbase.checkUsername(username);
				if(flag==true){
				System.out.print("Please  try some other user name.This user name already exists");
			 }
				
			 }
	
	}
	
	
	
void pWord(){
		flag=true;
		 while(flag==true){
			System.out.println("Enter Password");
			
			password=s.next();
			flag=dbase.checkPassword(password);
			if(flag==true){
				System.out.print("Please  try some other password.");
			 }
			 }
	}


 void phone(){
	 while(flag==true){
		  System.out.println("Enter Phone");
			phone=s.next();
			flag=dbase.checkPhone(phone);
			if(flag==true){
				System.out.print("Please enter a valid phone number.");
			 }
		  } 
 }

void allOtherDetails(){

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
	
}

 void moderator() {
	// TODO Auto-generated method stub
	 Moderator moduser=new Moderator(username, password,firstname,  lastname,  email1, email2, pic1, pic2,pic3, aboutme,
				streetname, streetno, postal,  mun, "new", dis,phone);
	 dbase.addModeratorToDatabase(moduser);
  boolean flag=true;
  while(flag)
  {
	 dbase.showQualifications();
	 int id=s.nextInt();
	 dbase.addModeratorQualificationToDatabase(moduser, id);
	 System.out.println("Do you want to enter more? \n press 1 for yes \n press 2 to exit");
  int x=s.nextInt();
  if(x==2)
	  flag=false;
  }
  
}



 void admin() {
	// TODO Auto-generated method stub
	 Admin aduser=new Admin(username, password,firstname,  lastname,  email1,
				email2, pic1, pic2,pic3,aboutme, phone,
				streetname,streetno, postal,  mun,"new", dis);
		dbase.addAdminToDatabase(aduser);
}



 void endUser() {
	// TODO Auto-generated method stub
	 EndUser euser=new EndUser(username, password,firstname,  lastname,  email1,
				
				email2, pic1, pic2,pic3,aboutme,
				streetname,streetno, postal,  mun,"new", dis);
		
		dbase.addEndUserToDatabase(euser);
}



 void updateProfile(String Uname) {
	// TODO Auto-generated method stub
	  System.out.println("Select the field you want to update:   \n"+"\n 1: password"+"\n 2: email2"+"\n"
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



 void healthData(String Uname) {
	// TODO Auto-generated method stub
	 boolean flag2=true;
	 while(flag2==true){
	 System.out.println("Select from the following:   \n"+"\n 1: add health data"+"\n 2: show health data" +"\n 3: exit from health data");
	       int k=0;
	       boolean flag1=true;
	       k=s.nextInt();
	       if(k==1){
	    	   System.out.println("List of Health Data");
	    	   hdbase.showProperty();
	    	   while(flag1==true){
	    	   System.out.println("Which health data you want to add?");
	    	   int hdata=0;
	        
	           hdata=h.nextInt();
	           System.out.println("Enter the value");
	           String val=null;
	           val=h.next();
	    	   
	    	   HealthData hd=new HealthData(Uname,hdata,val);
	    	   hdbase.setHealthDataToDatabase(hd);
	    	   System.out.println("Do you want to enter any more health data?");
	    	
	    	   System.out.println("Enter 1 to continue and 2 to stop");
	    	   opinion=h.nextInt();
	    	   if(opinion==1)
	    		   flag1=true;
	    	   if(opinion==2)
	    		   flag1=false;	    	   
	    	   }
	       }
	    	if(k==2){
	    		System.out.println("Press 1 to see your own health data and press 2 to see your friend's health data");
	    		opinion=h.nextInt();
	    		if(opinion==1){
	    			hdbase.showHealthData(Uname);
	    			
	    		}
	    		if(opinion==2){
	    			System.out.println("Enter the name of the friend whose health data you want to check");
	    			String friend=null;
	    			friend=h.next();
	    			flag= hdbase.checkFriendship(Uname, friend);
	    			if(flag==true){
	    				hdbase.showHealthData(friend);
	    			}
	    			else
	    				System.out.println(friend+" is not your friend and so you can not see his/her health data");
	    			
	    		}
	    		}
	    	if(k==3){
	    		flag2=false;
	    	}
	 }
	    	
}



 void forum(String Uname) {
	// TODO Auto-generated method stub
	 boolean flag2=true;
	 while(flag2==true){
		 
	 System.out.println("Select from the following:   \n"+"\n 1: Create Forum"
	+"\n 2: List Forums"
	+"\n 3: Delete Forum" 
	+ "\n 4: Exit"
	);
	 
	 int k=0;
     boolean flag1=true;
     k=s.nextInt();
     if(k==4)
     {
    	 break;
     }
     
     if(k==1){
    	 boolean flag3=true;
    
    	 flag3=fdbase.checkModerator(Uname);
    	 if(flag3==true){System.out.println("You can proceed");
    	 System.out.println("Enter the topic name");
    	 String topic=null;
    	 topic=f.next();
    	 System.out.println("Enter URL");
    	 String url=null;
    	 url=f.next();
    	 System.out.println("Enter Summary");
    	 String summary=null;
    	 summary=f.next();
    	
    	 String modname=Uname;
    	 Forum fr=new Forum(topic,url,summary,modname);
    	 
    	 fdbase.addForumToDatabase(fr);
    	 }
    	 else 
    		 System.out.println("You are not a moderator and hence can not create a forum.");
    	 
    	 
    	 
     }
     if (k==2){
    	 System.out.println("List of Forums:-");
    	 fdbase.viewForum();
    	 System.out.println("Posts of which forum do you want to view?");
    	 int val=0;
    	 val=f.nextInt();
    	 fdbase.viewPost(val);
    	 System.out.println("Press 1 to add post to database,\n Press 2 to rate database,\n Press 3 to enter comment");
    	 int choice=0;
    	 choice=f.nextInt();
    	 if (choice==1){
    		 java.util.Date dt = new  java.util.Date();
    	      
    		   	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    		  String 	timecreated= sdf.format(dt);
    		 
    		
    		 
    		 System.out.println("Enter forumid");
    		 String forumid=null;
    		 forumid=r.next();
    		 
    		 System.out.println("Enter textentry");
    		 String textentry=null;
    		 textentry=r.next();
    		textentry+=r.nextLine();
    		 
    		 System.out.println("Enter photolocation");
    		 String photolocation=null;
    		 photolocation=r.nextLine();
    		 
    		 System.out.println("Enter linklocation");
    		 String linklocation=null;
    		 linklocation=r.nextLine();
    		 
    		 System.out.println("Enter videolocation");
    		 String videolocation=null;
    		 videolocation=r.nextLine();
    		 
    		 fdbase.addPostToDatabase(Uname, timecreated, forumid, textentry, photolocation, linklocation, videolocation);
    		 
    	 }
    	 
    	 if(choice==2){
    		 
    		 System.out.println("Enter postusername");
    		 String postusername=null;
    		 postusername=r.next();
    		
    		 
    		
 		  String 	posttimecreated= null;
 		 
 		 System.out.println("Enter their post number");
 		 int l=r.nextInt();
 		 {
 			 posttimecreated=fdbase.getPostTime(l, postusername,val);
 		 }
 		 
    		 System.out.println("Enter stars");
    		 String stars=null;
    		 stars=r.next();
    		 try
    		 { fdbase.addRatingToDatabase(postusername, posttimecreated, Uname, stars);}
    		 catch(Exception e)
    		 {
    			 System.out.println("There was some error");
    		 }
    	 }
    	 if(choice==3)
    	 {
    		 
    		 System.out.println("Enter postusername");
    		 String postusername=null;
    		 postusername=r.next();
    		
    		 
    		
 		  String 	posttimecreated= null;
 		 
 		 System.out.println("Enter their post number");
 		 int l=r.nextInt();
 		 {
 			 posttimecreated=fdbase.getPostTime(l, postusername,val);
 		 }
 		 
 		 System.out.println("Enter textentry");
		 String textentry=null;
		 textentry=r.next();
		textentry+=r.nextLine();
		 
		 System.out.println("Enter photolocation");
		 String photolocation=null;
		 photolocation=r.nextLine();
		 
		 System.out.println("Enter linklocation");
		 String linklocation=null;
		 linklocation=r.nextLine();
		 
		 System.out.println("Enter videolocation");
		 String videolocation=null;
		 videolocation=r.nextLine();
		 java.util.Date dt = new  java.util.Date();
	      
		   	java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		   	String commentdate= sdf.format(dt);
    		 try
    		 
    		 { fdbase.addCommentToDatabase(postusername, posttimecreated,Uname, commentdate, textentry, photolocation, linklocation, videolocation);}
    		 catch(Exception e)
    		 {
    			 System.out.println("There was some error");
    		 }
    	 }
    	 
     }
	 
	 }	 
	 
}



 
 
}