import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPratikan {
    boolean menu2;
    private HashMap<String, String> tabelData;
    private HashMap<String, String> tabelSesiLogin;

    public DataPratikan() {
        tabelData = new HashMap<String, String>();
        tabelSesiLogin = new HashMap<String, String>();
    }

    public boolean tambahData(String nimPratikan, String namaAsisten) {
        if (nimPratikan.startsWith("IF") && !tabelData.containsKey(nimPratikan)) {
            tabelData.put(nimPratikan, namaAsisten);
            System.out.println("Data Berhasil Ditambahkan");
            return true;
        } else {
            if (!nimPratikan.startsWith("IF")) {
                System.out.println("NIM harus berawalan dengan IF");
            } else if (tabelData.containsKey(nimPratikan)) {
                System.out.println("Data dengan NIM tersebut sudah ditambahkan");
            }
            return false;
        }
    }

    public void tampil() {
        System.out.println("Total Data yang Tersimpan: " + totalEmail());
        if (totalEmail() == 0) {
            System.out.println("Data Empty");
        } else {
            for (Map.Entry<String, String> entry : tabelData.entrySet()) {
                System.out.println("NIM: " + entry.getKey() + "\tNAMA: " + entry.getValue());
            }
        }
    }


    public void listNimPratikan() {
        if (totalEmail() == 0) {
            System.out.println("Data Empty");
        } else {
            for (String key : tabelData.keySet()) {
                System.out.println(key);
            }
        }
    }

    public void listNamaAsisten() {
        if (totalEmail() == 0) {
            System.out.println("Data Empty");
        } else {
            for (String value : tabelData.values()) {
                System.out.println(value);
            }
        }
    }

    public int totalEmail() {
        return tabelData.size();
    }

    public boolean hapusData(String nimPratikan, String namaAsisten) {
        if (tabelData.containsKey(nimPratikan) && tabelData.get(nimPratikan).equals(namaAsisten)) {
            tabelData.remove(nimPratikan);
            System.out.println("Data berhasil dihapus");
            return true;
        } else {
            System.out.println("Data tersebut tidak terdaftar");
            return false;
        }
    }

    public void editData(String nimPratikan, String namaAsisten) {
        Scanner inputUser = new Scanner(System.in);
        if (tabelData.containsKey(nimPratikan) && tabelData.containsValue(namaAsisten)) {
            System.out.println("------------------------------");
            System.out.println("Masukkan data baru!");
            System.out.print("Masukkan NIM: ");
            String nimBaru = inputUser.next();
            inputUser.nextLine();
            System.out.print("Masukkan Nama Asisten: ");
            String namaBaru = inputUser.nextLine();
            tabelData.replace(nimBaru, namaBaru);
            System.out.println("Data berhasil diubah");
        } else {
            System.out.println("Data tidak terdaftar");
        }
    }

    public void searchData(String namaAsisten) {
        System.out.println("Daftar NIM Praktikan dengan Asisten " + namaAsisten + ":");
        if (tabelData.containsValue(namaAsisten)) {
            for (String key : tabelData.keySet()) {
                if (tabelData.get(key).equals(namaAsisten)) {
                    System.out.println(key);
                }
            }
        } else {
            System.out.println("Tidak ada data NIM pratikan dengan nama asisten " + namaAsisten);
        }
    }

    public void tambahSesiLogin(String email, String password) {
        tabelSesiLogin.put(email, password);
    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan email: ");
        String email = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        if (tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password)) {
            System.out.println("Login berhasil!");
            menu2 = true;
        } else if (!email.endsWith("@umm.ac.id")) {
            System.out.println("Gagal login: domain email tidak valid");
            menu2 = false;
        } else {
            System.out.println("Gagal login: email atau password salah");
            menu2 = false;
        }
    }

    public static void main(String[] args) {
        int clue = 0;
        DataPratikan dataPratikan = new DataPratikan();
        dataPratikan.tambahSesiLogin("laryntsa@umm.ac.id", "12345");
        dataPratikan.tambahSesiLogin("nana@umm.ac.id", "12345");
        Scanner inputUser = new Scanner(System.in);
        while (true) {
            if (clue != 0) {
                dataPratikan.menu2 = true;
            }
            System.out.println("===== Menu Login =====");
            dataPratikan.login();
            System.out.println();
            while (dataPratikan.menu2) {
                System.out.println("===== DATA LIST PRAKTIKAN UNTUK PRAKTIKUM =====");
                System.out.println("1. Tambah Data");
                System.out.println("2. All Data");
                System.out.println("3. Data NIM Pratikan");
                System.out.println("4. Data Nama Asisten");
                System.out.println("5. Total Email ");
                System.out.println("6. Hapus Data");
                System.out.println("7. Edit Data");
                System.out.println("8. Search Data");
                System.out.println("9. Logout");
                System.out.print("Choose Menu : ");
                int menu = inputUser.nextInt();
                switch (menu) {
                    case 1: {
                        System.out.println("\n--- Tambah Data Baru ---");
                        System.out.print("Masukkan NIM: ");
                        String nim = inputUser.next();
                        inputUser.nextLine();
                        System.out.print("Masukkan Nama Asisten: ");
                        String namaAsisten = inputUser.nextLine();
                        dataPratikan.tambahData(nim, namaAsisten);
                        System.out.println();
                        break;
                    }
                    case 2: {
                        System.out.println("\n--- Show All Data ---");
                        dataPratikan.tampil();
                        System.out.println();
                        break;
                    }
                    case 3: {
                        System.out.println("\n--- Show Data NIM Pratikan ---");
                        dataPratikan.listNimPratikan();
                        System.out.println();
                        break;
                    }
                    case 4: {
                        System.out.println("\n--- Show Data Nama Asisten ---");
                        dataPratikan.listNamaAsisten();
                        System.out.println();
                        break;
                    }
                    case 5: {
                        System.out.println("\n--- Show Total Data ---");
                        System.out.println("Total Data: " + dataPratikan.totalEmail());
                        System.out.println();
                        break;
                    }
                    case 6: {
                        System.out.println("\n--- Delete Data ---");
                        System.out.print("Masukkan NIM: ");
                        String nim = inputUser.next();
                        inputUser.nextLine();
                        System.out.print("Masukkan Nama Asisten: ");
                        String namaAsisten = inputUser.nextLine();
                        dataPratikan.hapusData(nim, namaAsisten);
                        System.out.println();
                        break;
                    }
                    case 7: {
                        System.out.println("\n--- Edit Data ---");
                        System.out.print("Masukkan NIM : ");
                        String nim = inputUser.next();
                        inputUser.nextLine();
                        System.out.print("Masukkan Nama Asisten : ");
                        String namaAsisten = inputUser.nextLine();
                        dataPratikan.editData(nim, namaAsisten);
                        System.out.println();
                        break;
                    }
                    case 8: {
                        System.out.println("\n--- Search Data ---");
                        inputUser.nextLine();
                        System.out.print("Masukkan Nama Asisten : ");
                        dataPratikan.searchData(inputUser.nextLine());
                        System.out.println();
                        break;
                    }
                    case 9: {
                        dataPratikan.menu2 = false;
                        clue++;
                    }
                }
            }
        }
    }
}
