/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.padroes;

/**
 *
 * @author beruas
 */
// Interface que define o contrato para todos os handlers na cadeia.
interface Handler {
    // Define o próximo handler na cadeia e retorna o handler para permitir encadeamento fluente.
    Handler setNext(Handler handler);
    // Processa a requisição. Se o handler não puder processá-la, ele a passa para o próximo handler na cadeia.
    String handle(String request);
}

// Classe abstrata que implementa a lógica básica para encadear os handlers.
abstract class AbstractHandler implements Handler {
    // Armazena o próximo handler na cadeia.
    private Handler nextHandler;

    // Define o próximo handler na cadeia.
    @Override
    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler; // Retorna o handler para permitir encadeamento fluente.
    }

    // Processa a requisição. Se houver um próximo handler, a requisição é passada adiante; caso contrário, retorna null.
    @Override
    public String handle(String request) {
        if (nextHandler != null) {
            return nextHandler.handle(request);
        }
        return null;
    }
}

// Handler concreto que lida com requisições de suporte técnico.
class TechSupportHandler extends AbstractHandler {
    // Verifica se a requisição é do tipo "Technical Issue". Se for, processa a requisição; caso contrário, passa para o próximo handler.
    @Override
    public String handle(String request) {
        if (request.equals("Technical Issue")) {
            return "Tech Support: I'll handle the " + request;
        } else {
            return super.handle(request);
        }
    }
}

// Handler concreto que lida com requisições de suporte de cobrança.
class BillingSupportHandler extends AbstractHandler {
    // Verifica se a requisição é do tipo "Billing Issue". Se for, processa a requisição; caso contrário, passa para o próximo handler.
    @Override
    public String handle(String request) {
        if (request.equals("Billing Issue")) {
            return "Billing Support: I'll handle the " + request;
        } else {
            return super.handle(request);
        }
    }
}

// Handler concreto que lida com requisições de suporte geral.
class GeneralSupportHandler extends AbstractHandler {
    // Verifica se a requisição é do tipo "General Inquiry". Se for, processa a requisição; caso contrário, passa para o próximo handler.
    @Override
    public String handle(String request) {
        if (request.equals("General Inquiry")) {
            return "General Support: I'll handle the " + request;
        } else {
            return super.handle(request);
        }
    }
}

// Classe principal que demonstra o uso do padrão Chain of Responsibility.
public class ChainOfResponsibility {
    // Método que simula um cliente enviando requisições e imprimindo os resultados.
    public static void clientCode(Handler handler) {
        String[] requests = {"Billing Issue", "Technical Issue", "General Inquiry"};
        for (String request : requests) {
            System.out.println("\nClient: Who can handle a " + request + "?");
            String result = handler.handle(request);
            if (result != null) {
                System.out.print("  " + result);
            } else {
                System.out.print("  " + request + " was left unhandled.");
            }
        }
    }

    // Método principal que cria os handlers, os encadeia e chama o clientCode() para testar a cadeia.
    public static void main(String[] args) {
        // Cria os handlers.
        TechSupportHandler techSupport = new TechSupportHandler();
        BillingSupportHandler billingSupport = new BillingSupportHandler();
        GeneralSupportHandler generalSupport = new GeneralSupportHandler();

        // Encadeia os handlers: Tech Support > Billing Support > General Support.
        techSupport.setNext(billingSupport).setNext(generalSupport);

        // Testa a primeira cadeia.
        System.out.println("Chain: Tech Support > Billing Support > General Support");
        clientCode(techSupport);
        System.out.println("\n");

        // Encadeia os handlers: Billing Support > General Support.
        // billingSupport.setNext(generalSupport); // Se você quiser testar uma subcadeia

        // Testa a segunda cadeia (subcadeia).
        System.out.println("Subchain: Billing Support > General Support");
        clientCode(billingSupport);
    }
}