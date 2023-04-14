class Mahasiswa:
    def __init__(self, nm, kl, mat, ni):
        self.nama = nm
        self.kelas = kl
        self.matkulPraktikum = mat
        self.nim = ni

if __name__ == '__main__':
    mhs = {
        "1": Mahasiswa("Putri", "3H", "Struktut Data", 2020000),
        "2": Mahasiswa("Agus", "3A", "Matematika", 2020012),
        "3": Mahasiswa("Arro", "3D", "Pemrograman", 2020017)
    }

    input_id = input("Masukkan ID: ")
    data = mhs.get(input_id)

    if data is not None:
        print(f"Data Mahasiswa : {data.nama}, kelas : {data.kelas}, mata kuliah praktikum : {data.matkulPraktikum}, nim : {data.nim}")