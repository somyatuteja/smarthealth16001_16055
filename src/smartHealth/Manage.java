/*
import java.util.ArrayList;
import java.util.Iterator;

public class Manage {
  static ArrayList<EndUser> arrEndUser=new ArrayList<>();  
  static ArrayList<Admin> arradmin=new ArrayList<>(); 
  static ArrayList<Moderator> arrmod=new ArrayList<>();  
static ArrayList<User> arrdelper=new ArrayList<>();
 
  public boolean checkEndUsername(String un)
  {  
 Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{    
   EndUser u=(EndUser) iu.next();
   
}
while(ia.hasNext())
{
   Admin a=(Admin) ia.next();
   if(un.equals(a.getEndUsername()))
    
   {
       System.out.println("called fun"+a.getEndUsername());
        return true;
    }
}
while(im.hasNext())
{
   Moderator m=(Moderator) im.next();
   if(un.equals(m.getEndUsername()))
    {
        System.out.println("called fun"+m.getEndUsername());
        return true;
    }
}
return false;
  }
 public String getPassword(String un)
 {
Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{    
   EndUser u=(EndUser) iu.next();
   if(un.equals(u.getEndUsername()))
    {
        return u.password;    
    }
}
while(ia.hasNext())
{
   Admin a=(Admin) ia.next();
   if(un.equals(a.getEndUsername()))
    
   {
       return a.password;
    }
}
while(im.hasNext())
{
   Moderator m=(Moderator) im.next();
   if(un.equals(m.getEndUsername()))
    {
       return m.password;
    }
}
return null;    
 }
 String delAccount(String un)
 {
     Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{    
   User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    {
       arrdelper.add(u);
       iu.remove();
       return "SUCCESSFULLY DELETED";
    }
}
while(ia.hasNext())
{
   User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {
arrdelper.add(a);
       ia.remove();     
       return "SUCCESSFULLY DELETED";
    }
}
while(im.hasNext())
{
   User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    {
       arrdelper.add(m);
       im.remove(); 
       return "SUCCESSFULLY DELETED";
    }
}
return "THERE WAS SOME ERROR! \n TRY AGAIN";
}
  String updateFirstName(String un,String newdata)
 {
     Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{    
   User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    {
       u.fname=newdata;
       return "SUCCESSFULLY UPDATED";
    }
}
while(ia.hasNext())
{
   User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {
               a.fname=newdata;
               return "SUCCESSFULLY UPDATED";
    }
}
while(im.hasNext())
{ User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    {m.fname=newdata; 
      return "SUCCESSFULLY UPDATED"; }
}return "THERE WAS SOME ERROR! \n TRY AGAIN";}
  String updateLastName(String un,String newdata)
 {Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{    
   User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    { u.lname=newdata;
       return "SUCCESSFULLY UPDATED";}}
while(ia.hasNext())
{
   User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {  a.lname=newdata;
               return "SUCCESSFULLY UPDATED";  }}
while(im.hasNext())
{
   User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    { m.lname=newdata; 
      return "SUCCESSFULLY UPDATED"; }}
return null;
}
  String changeAddress(String un,String newdata)
 {
     Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{  User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    { u.address=newdata;
       return "SUCCESSFULLY UPDATED"; }
}
while(ia.hasNext())
{ User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           { a.address=newdata;
               return "SUCCESSFULLY UPDATED";    }}
while(im.hasNext())
{ User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    {m.address=newdata; 
      return "SUCCESSFULLY UPDATED";    }}
return "THERE WAS SOME ERROR! \n TRY AGAIN";}
  String updatePassword(String un,String newdata)
 { Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{  User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    { u.password=newdata;
       return "SUCCESSFULLY UPDATED";
    }
}
while(ia.hasNext())
{
   User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {
               a.password=newdata;
               return "SUCCESSFULLY UPDATED";    }}
while(im.hasNext())
{ User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    { m.password=newdata; 
      return "SUCCESSFULLY UPDATED"; }}
return "THERE WAS SOME ERROR! \n TRY AGAIN";}
  String updateAboutMe(String un,String newdata)
 { Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{  User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    { u.aboutme=newdata;
       return "SUCCESSFULLY UPDATED";}}
while(ia.hasNext())
{
   User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {
               a.aboutme=newdata;
               return "SUCCESSFULLY UPDATED";}}
while(im.hasNext())
{ User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    {m.aboutme=newdata; 
      return "SUCCESSFULLY UPDATED";
    }} return "THERE WAS SOME ERROR! \n TRY AGAIN";}
  String updatePic(String un,String newdata)
 {
     Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{ User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    {u.photo1=newdata;
       return "SUCCESSFULLY UPDATED"; }}
while(ia.hasNext())
{ User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {  a.photo1=newdata;
               return "SUCCESSFULLY UPDATED";}}
while(im.hasNext())
{User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    {m.photo1=newdata; 
      return "SUCCESSFULLY UPDATED";}} return "THERE WAS SOME ERROR! \n TRY AGAIN"; }
  String updateEmail(String un,String newdata)
 {Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{  User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    { u.email2=newdata;
     return "SUCCESSFULLY UPDATED"; }}
while(ia.hasNext())
{ User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           { a.email2=newdata;
               return "SUCCESSFULLY UPDATED";  }}
while(im.hasNext())
{ User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    {m.email2=newdata; 
      return "SUCCESSFULLY UPDATED"; }
} return "THERE WAS SOME ERROR! \n TRY AGAIN";}
  String getType(String un)
  {
      Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{    
   User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    {
       return "EndUser";
    }
}
while(ia.hasNext())
{
   User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {
              return "admin";
    }
}
while(im.hasNext())
{
   User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    {
     return "mod";
    }
}
return null;
  }
String updateNumber(String un, int cno)
{    String type=this.getType(un);
    if(type.equals("EndUser"))
    {        return "YOU DONT HAVE CELL NO.";}
     if(type.equals("ADMIN"))
     {  Iterator ia=arradmin.iterator();
         while(ia.hasNext())
{   Admin a=(Admin) ia.next();
   if(un.equals(a.EndUsername))    {
     a.updateCno(cno);
     return "SUCCESSFULLY UPDATED";}} }
      if(type.equals("MOD"))
     {  Iterator im=arrmod.iterator();
         while(im.hasNext())
{ Moderator a=(Moderator) im.next();
   if(un.equals(a.EndUsername))
           {
     a.updateCno(cno);
     return "SUCCESSFULLY UPDATED";
    }}}      return null;}

String updateQual(String un, String qual)
{ String type=this.getType(un);
    if(type.equals("EndUser"))
    {return "YOU DONT HAVE QUALIFICATIONS"; }
     if(type.equals("ADMIN"))
     {Iterator ia=arradmin.iterator();
         while(ia.hasNext())
{ Admin a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {     a.updateQual(qual);
     return "SUCCESSFULLY UPDATED";}} }
      if(type.equals("MOD"))
     { Iterator im=arrmod.iterator();
         while(im.hasNext())
{ Moderator a=(Moderator) im.next();
   if(un.equals(a.EndUsername))
           { a.updateQual(qual);
     return "SUCCESSFULLY UPDATED";
    }}     }
return "THERE WAS SOME ERROR! \n TRY AGAIN";}

String getUser(String un)
{
    Iterator iu=arrEndUser.iterator();
Iterator ia=arradmin.iterator();
Iterator im=arrmod.iterator();
while(iu.hasNext())
{    
   User u=(EndUser) iu.next();
   if(un.equals(u.EndUsername))
    {
       return u.toString();
       
    }
}
while(ia.hasNext())
{
   User a=(Admin) ia.next();
   if(un.equals(a.EndUsername))
           {
               return a.toString();
    }
}
while(im.hasNext())
{
   User m=(Moderator) im.next();
   if(un.equals(m.EndUsername))
    {
     return m.toString();
    }
}
return null;
}

}*/