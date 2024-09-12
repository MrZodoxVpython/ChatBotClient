import java.io.*;
import java.net.*;

public class BotServer {
    public static void main(String[] args) {
        try {
            // Membuat socket server di port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Bot sedang menunggu client untuk terhubung...");

            // Menerima koneksi dari client
            Socket socket = serverSocket.accept();
            System.out.println("Client terhubung!");

            // Membuat input dan output stream untuk komunikasi
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Percakapan bot dengan client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);

                // Cek apakah client ingin keluar
                if (message.equalsIgnoreCase("keluar")) {
                    out.println("Bot: Terima kasih, sampai jumpa!");
                    break;
                }

                // Bot merespons otomatis
                String response;
                if (message.toLowerCase().contains("halo")) {
                    response = "Bot: Halo, ada yang bisa saya bantu?";
                } else if (message.toLowerCase().contains("apa kabar")) {
                    response = "Bot: Saya baik, bagaimana dengan Anda?";
                } else {
                    response = "Bot: Maaf, saya tidak mengerti.";
                }

                // Kirimkan balasan ke client
                out.println(response);
            }

            // Tutup koneksi
            socket.close();
            serverSocket.close();
            System.out.println("Bot telah berhenti.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
