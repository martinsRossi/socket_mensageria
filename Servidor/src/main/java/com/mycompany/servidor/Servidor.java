package com.mycompany.servidor;

import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] a) {
    ServerSocket canal = null;
    Socket socketCli = null;
    BufferedReader entCli = null;
    String ltr;

    try {
    canal = new ServerSocket(4445);
    System.out.println("Serv. Ativo\n");
    System.out.println("Esp. Cliente\n");
    socketCli = canal.accept();
    entCli = new BufferedReader(
    new InputStreamReader(
    socketCli.getInputStream())
    );

    while ((ltr=entCli.readLine())!=null){
    System.out.println("CLI >> " + ltr);
    if (ltr.equals("FIM"))
    break;
    }
    entCli.close();
    socketCli.close();
    canal.close();

    } catch (IOException e) {
    System.out.println(
    "Falha na comunicação.");
    System.exit(1);
    }
    }
}
