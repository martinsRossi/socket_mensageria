/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cliente;



import java.net.*;
import java.io.*;

public class Cliente {
    public static void main(String[] args){
        Socket socketServ = null;
        PrintWriter saiServ = null;
        BufferedReader teclado = null;
        String ltr;

        
        try {
            socketServ = new Socket(
                "10.70.1.153", 4445);
            System.out.println("Conectado...\n");
            saiServ = new PrintWriter(
                socketServ.getOutputStream(),true);

            teclado = new BufferedReader(
                new InputStreamReader(
                    System.in));
            
            while (true){
                ltr = teclado.readLine();
                saiServ.println(ltr);
                if (ltr.equals("FIM"))
            break;
            }
            saiServ.close();
            socketServ.close();

        } catch (UnknownHostException e) {
            System.out.println(
            "Host desconhecido.");
            System.exit(1);
            } catch (IOException e) {
            System.out.println(
            "Problemas de E/S na Conexão.");
            System.exit(1);
            }
        }
}