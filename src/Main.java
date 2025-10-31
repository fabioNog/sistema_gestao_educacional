import ui.MenuUI;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema de Gestão Educacional - EduConnect");
        System.out.println("Nome: Fabio Nogueira do Carmo | RA: 25132907-5");

        MenuUI menu = new MenuUI();
        menu.exibirMenu();

        System.out.println("Sistema finalizado.");
    }
}