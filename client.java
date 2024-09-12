import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Membuat socket dan terhubung ke server di localhost port 12345
            Socket socket = new Socket("localhost", 12345);

            // Membuat input dan output stream untuk komunikasi
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Percakapan dengan bot
            String message;
            while (true) {
                // Input dari pengguna
                System.out.print("Anda: ");
                message = userInput.readLine();
                out.println(message);  // Kirim pesan ke bot

                if (message.equalsIgnoreCase("keluar")) {
                    break;  // Keluar dari loop jika pengguna mengetik 'keluar'
                }

                // Menerima respons dari bot
                String response = in.readLine();
                System.out.println(response);
            }

            // Tutup koneksi
            socket.close();
            System.out.println("Koneksi ditutup.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
