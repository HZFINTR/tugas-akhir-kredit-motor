package tugasakhirfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hamam Zul Fahmi
 */
public class Tugasakhirfinal {
    
    static ArrayList<Integer> nomorPembeli = new ArrayList<>();
    static ArrayList<String> namaPembeli = new ArrayList<>();
    static ArrayList<String> nikPembeli = new ArrayList<>();
    static ArrayList<String> umurPembeli = new ArrayList<>();
    static ArrayList<String> alamatPembeli = new ArrayList<>();
    static ArrayList<Double> noHpPembeli = new ArrayList<>();
    static ArrayList<String> namaMotor = new ArrayList<>();
    static ArrayList<Double> hargaMotor = new ArrayList<>();
    static ArrayList<Double> uangMuka = new ArrayList<>();
    static ArrayList<Integer> tenor = new ArrayList<>();
    static ArrayList<Double> angsuran = new ArrayList<>();
    static ArrayList<Double> bunga = new ArrayList<>();
    static boolean isRunning = true;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (isRunning) {
            showMenu();
        }
    }
    
    static void showMenu() throws IOException {
        String iMenu = "";
        do {
        System.out.println("========== MENU ==========");
        System.out.println("[1] Show Data");
        System.out.println("[2] Insert Data");
        System.out.println("[3] Edit Data");
        System.out.println("[4] Delete Data");
        System.out.println("[5] Exit");
        System.out.print("PILIH MENU > ");

        iMenu = (br.readLine());
        }while(!iMenu.matches("[12345]"));
        
        int selectedMenu = Integer.parseInt(iMenu);
        
        switch (selectedMenu) {
            case 1:
                showAllData();
                break;
            case 2:
                insertData();
                break;
            case 3:
                editData();
                break;
            case 4:
                deleteData();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Error!");
        }
    }
    
    static void showAllData() throws IOException {
    Scanner scanner = new Scanner(System.in);
    int halaman = 1;
    int dataHalaman = 3;
    int totalHalaman = (int) Math.ceil((double) nomorPembeli.size() / dataHalaman);
    double grandTotalHarga = 0;
    double grandTotalUangMuka = 0;
    double grandTotalAngsuran = 0;
    double grandTotalBunga = 0;
    
    while (true) {
        System.out.println("\nData Pemilik Kredit Motor");
        System.out.println("Hal " + halaman + "\n");
        
        if (nomorPembeli.isEmpty()) {
            System.out.println("Data Tidak Tersedia.");
            return;
        } else {
             double subtotalHarga = 0, subtotalUangMuka = 0, subtotalAngsuran = 0, subtotalBunga = 0;
             
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| No |    Nama Pembeli    |         NIK        | Umur |                            Alamat                          |        Nomor Hp.        |        Nama Motor      |        Harga       |       Uang Muka       |   Tenor   |   Angsuran/Bulan   |   Bunga/Bln   |\n");
        System.out.printf("|----+--------------------+--------------------+------+------------------------------------------------------------+-------------------------+------------------------+--------------------+-----------------------+-----------+--------------------|---------------|\n");

        int start = (halaman - 1) * dataHalaman;
        int end = Math.min(start + dataHalaman, nomorPembeli.size());

        for (int i = start; i < end; i++) {
            subtotalHarga += hargaMotor.get(i);
            subtotalUangMuka += uangMuka.get(i);
            subtotalAngsuran += angsuran.get(i);
            subtotalBunga += bunga.get(i);

            System.out.printf("| %-2d | %-18s | %-18s | %-4s | %-58s | %-23.0f | %-22s | %-18.2f | %-21.2f | %-9d | %-18.2f | %-13.2f |\n",
                    i + 1,
                    namaPembeli.get(i),
                    nikPembeli.get(i),
                    umurPembeli.get(i),
                    alamatPembeli.get(i),
                    noHpPembeli.get(i),
                    namaMotor.get(i),
                    hargaMotor.get(i),
                    uangMuka.get(i),
                    tenor.get(i),
                    angsuran.get(i),
                    bunga.get(i)
            );
        }

        System.out.printf("|----+--------------------+--------------------+------+------------------------------------------------------------+-------------------------+------------------------+--------------------+-----------------------+-----------+--------------------|---------------|\n");
        System.out.printf("|    | %-18s | %-18s |      | %-58s |                         | %-22s | %-18.2f | %-21.2f |           | %-18.2f | %-13.2f |\n",
                "Subtotal",
                "",
                "",
                "",
                subtotalHarga,
                subtotalUangMuka,
                subtotalAngsuran,
                subtotalBunga);
        System.out.printf("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
        
        grandTotalHarga += subtotalHarga;
        grandTotalUangMuka += subtotalUangMuka;
        grandTotalAngsuran += subtotalAngsuran;
        grandTotalBunga += subtotalBunga;
        
        if (halaman == totalHalaman) {
        System.out.printf("|----+--------------------+--------------------+------+------------------------------------------------------------+-------------------------+------------------------+--------------------+-----------------------+-----------+--------------------|---------------|\n");
        System.out.printf("|    | %-18s | %-18s |      | %-58s |                         | %-22s | %-18.2f | %-21.2f |           | %-18.2f | %-13.2f |\n",
            "Grand Total",
            "",
            "",
            "",
            grandTotalHarga,
            grandTotalUangMuka,
            grandTotalAngsuran,
            grandTotalBunga);
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("Sudah Mencapai Data Akhir.");

        }

        // Navigasi halaman
        System.out.println("\nNavigasi: [N] Halaman Berikutnya | [P] Halaman Sebelumnya | [E] Keluar/Melanjutkan");
        System.out.print("Pilihan: ");
        String pilihan = scanner.nextLine().toUpperCase();

        if (pilihan.equals("N") && halaman < totalHalaman) {
            halaman++;
        } else if (pilihan.equals("P") && halaman > 1) {
            halaman--;
        } else if (pilihan.equals("E")) {
            break;
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    }
    }
    static void insertData() throws IOException {
        // DISINI DIBUNGKUS PROOFING
        
        System.out.print("Nomor Pembeli : ");
        int nomor = Integer.parseInt(br.readLine());


        System.out.print("Nama Pembeli  : ");
        String nama = br.readLine();

        System.out.print("NIK           : ");
        String nik = br.readLine();
        
        System.out.print("Umur          : ");
        String umur = br.readLine();
        
        System.out.print("Alamat        : ");
        String alamat = br.readLine();
        
        System.out.print("Nomor Hp.     : ");
        double nomorHp = Double.parseDouble(br.readLine());
        
        System.out.println("Pilih Jenis Motor:");
        System.out.println("1. Genio (Rp 10.000.000)");
        System.out.println("2. Scoopy (Rp 15.000.000)");
        System.out.println("3. PCX (Rp 25.000.000)");
        System.out.println("4. ADV (Rp 20.000.000)");
        System.out.println("5. CRF (Rp 21.000.000)");
        System.out.println("6. CBR (Rp 30.000.000)");
        System.out.print("Pilih Motor [1-6]: ");
        int pilihanMotor = Integer.parseInt(br.readLine());

        String jenisMotor = "";
        double hargaMotorValue = 0;

        switch (pilihanMotor) {
            case 1:
                jenisMotor = "Genio";
                hargaMotorValue = 10000000;
                break;
            case 2:
                jenisMotor = "Scoopy";
                hargaMotorValue = 15000000;
                break;
            case 3:
                jenisMotor = "PCX";
                hargaMotorValue = 25000000;
                break;
            case 4:
                jenisMotor = "ADV";
                hargaMotorValue = 20000000;
                break;
            case 5:
                jenisMotor = "CRF";
                hargaMotorValue = 21000000;
                break;
            case 6:
                jenisMotor = "CBR";
                hargaMotorValue = 30000000;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        double uangMukaValue = 0;
        do{
            System.out.print("Uang Muka (Minimal Rp 1.000.000): ");
            uangMukaValue = Double.parseDouble(br.readLine());
        }while(uangMukaValue < 1000000);
        
        System.out.println("Pilih Lama Cicilan:");
        System.out.println("1. 6 bulan");
        System.out.println("2. 12 bulan");
        System.out.println("3. 24 bulan");
        System.out.println("4. 36 bulan");
        System.out.print("Pilih Cicilan [1-4]: ");
        int pilihanCicilan = Integer.parseInt(br.readLine());

        int lamaCicilan = 0;
        switch (pilihanCicilan) {
            case 1:
                lamaCicilan = 6;
                break;
            case 2:
                lamaCicilan = 12;
                break;
            case 3:
                lamaCicilan = 24;
                break;
            case 4:
                lamaCicilan = 36;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        double cicilanBulanan = (hargaMotorValue - uangMukaValue) / lamaCicilan;
        double cicilanBulananBulat = (int) (Math.round(cicilanBulanan / 1000) * 1000);
        
        double bungaBln = 0;
        switch(pilihanCicilan){
            case 1 : 
                bungaBln = cicilanBulanan * 5 / 100;
                break;
            case 2 : 
                bungaBln = cicilanBulanan * 7 / 100;
                break;
            case 3 : 
                bungaBln = cicilanBulanan * 9 / 100;
                break;
            case 4 :
                bungaBln = cicilanBulanan * 10 / 100;
                break;
        }
        double bungaBulat = (int) (Math.round(bungaBln / 1000) * 1000);
        
        nomorPembeli.add(nomor);
        namaPembeli.add(nama);
        nikPembeli.add(nik);
        umurPembeli.add(umur);
        alamatPembeli.add(alamat);
        noHpPembeli.add(nomorHp);
        namaMotor.add(jenisMotor);
        hargaMotor.add(hargaMotorValue);
        uangMuka.add(uangMukaValue);
        tenor.add(lamaCicilan);
        angsuran.add(cicilanBulananBulat);
        bunga.add(bungaBulat);

        System.out.println("Data berhasil ditambahkan!");
    }

    static void editData() throws IOException {
        showAllData();
        System.out.print("Pilih nomor pembeli yang ingin diubah: ");
        int index = Integer.parseInt(br.readLine()) - 1;

        if (index >= 0 && index < nomorPembeli.size()) {
            System.out.print("Nama Pembeli baru: ");
            namaPembeli.set(index, br.readLine());

            System.out.print("NIK baru: ");
            nikPembeli.set(index, br.readLine());

            System.out.print("Umur baru: ");
            umurPembeli.set(index, br.readLine());

            System.out.print("Alamat baru: ");
            alamatPembeli.set(index, br.readLine());

            System.out.print("Nomor Hp. baru: ");
            noHpPembeli.set(index, Double.parseDouble(br.readLine()));

            System.out.println("Pilih Jenis Motor baru:");
            System.out.println("1. Genio (Rp 10.000.000)");
            System.out.println("2. Scoopy (Rp 15.000.000)");
            System.out.println("3. PCX (Rp 25.000.000)");
            System.out.println("4. ADV (Rp 20.000.000)");
            System.out.println("5. CRF (Rp 21.000.000)");
            System.out.println("6. CBR (Rp 30.000.000)");
            System.out.print("Pilih Motor baru [1-6]: ");
            int pilihanMotor = Integer.parseInt(br.readLine());

            String jenisMotor = "";
            double hargaMotorValue = 0;

            switch (pilihanMotor) {
                case 1:
                    jenisMotor = "Genio";
                    hargaMotorValue = 10000000;
                    break;
                case 2:
                    jenisMotor = "Scoopy";
                    hargaMotorValue = 15000000;
                    break;
                case 3:
                    jenisMotor = "PCX";
                    hargaMotorValue = 25000000;
                    break;
                case 4:
                    jenisMotor = "ADV";
                    hargaMotorValue = 20000000;
                    break;
                case 5:
                    jenisMotor = "CRF";
                    hargaMotorValue = 21000000;
                    break;
                case 6:
                    jenisMotor = "CBR";
                    hargaMotorValue = 30000000;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    return;
            }

            System.out.print("Uang Muka baru: ");
            double uangMukaValue = Double.parseDouble(br.readLine());

            System.out.println("Pilih Lama Cicilan baru:");
            System.out.println("1. 6 bulan");
            System.out.println("2. 12 bulan");
            System.out.println("3. 24 bulan");
            System.out.println("4. 36 bulan");
            System.out.print("Pilih Cicilan baru [1-4]: ");
            int pilihanCicilan = Integer.parseInt(br.readLine());

            int lamaCicilan = 0;
            switch (pilihanCicilan) {
                case 1:
                    lamaCicilan = 6;
                    break;
                case 2:
                    lamaCicilan = 12;
                    break;
                case 3:
                    lamaCicilan = 24;
                    break;
                case 4:
                    lamaCicilan = 36;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    return;
            }

            double cicilanBulanan = (hargaMotorValue - uangMukaValue) / lamaCicilan;
            namaMotor.set(index, jenisMotor);
            hargaMotor.set(index, hargaMotorValue);
            uangMuka.set(index, uangMukaValue);
            tenor.set(index, lamaCicilan);
            angsuran.set(index, cicilanBulanan);

            System.out.println("Data berhasil diubah!");
        } else {
            System.out.println("Nomor data tidak valid!");
        }
    }

    static void deleteData() throws IOException {
        showAllData();
        System.out.print("Pilih nomor pembeli yang ingin dihapus: ");
        int index = Integer.parseInt(br.readLine()) - 1;

        if (index >= 0 && index < nomorPembeli.size()) {
            nomorPembeli.remove(index);
            namaPembeli.remove(index);
            nikPembeli.remove(index);
            umurPembeli.remove(index);
            alamatPembeli.remove(index);
            noHpPembeli.remove(index);
            namaMotor.remove(index);
            hargaMotor.remove(index);
            uangMuka.remove(index);
            tenor.remove(index);
            angsuran.remove(index);
            bunga.remove(index);

            System.out.println("Data berhasil dihapus!");
        } else {
            System.out.println("Nomor data tidak valid!");
        }
    }
}

