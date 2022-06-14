package com.example.entity;


public interface RandomPassword
{
    int legth =12;

    // 0-9 in ASCII=> 48-57
    // A-Z in ASCII=> 65-90
    // a-z in ASCII=> 97-122
    // 32-47 & 58-64 & 91-96 & 123-126 in ASCII --- not all used but user created pw can use any of these.

    // for user simplicity we will only use special characters #=35, $=36, %=37, &=38

    public static String randomPassword(){
        String password= "";

        for(int i=0; i<8; i++){
            int ascii = (int) (Math.random()*66);

            if(ascii<4){
                password+= (char) (ascii+35);
            }else if(ascii<14) {
                password += (char) (ascii + 44);
            }else if(ascii<40) {
                password += (char) (ascii + 51);
            }else {
                password += (char) (ascii + 57);
            }
        }
        return password;
    }
}
