package ManagerSP;

import Models.Sanpham;
import Sort.SapXepSanPham;
import Validate.ValidateSanPham;
import io.ReaderAndWriter;

import javax.xml.bind.ValidationEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySanPham {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Sanpham> sanphams = new ArrayList<>();
    ValidateSanPham validateSanPham = new ValidateSanPham();
    ReaderAndWriter readerAndWriter = new ReaderAndWriter();

    public void menu() {
        System.out.println("=#=#=#=#=Menu=#=#=#=#=");
        System.out.println("1. Xem danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Sắp xếp sản phẩm");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi từ file");
        System.out.println("9. Thoát!!!");
        int choice = -1;
        try {
            System.out.println("Chọn mục: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice > 8) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Không có mục nào! Vui lòng chọn lại!!");
        }

        switch (choice) {
            case 1:
                showSanPham(sanphams);
                break;
            case 2:
                themSanPham(taoSanPham());
                System.out.println("Tạo thành công");
                break;
            case 3:
                capNhatSanPham();
                System.out.println("Cập nhật thành công");
                break;
            case 4:
                xoaSanPham();
                System.out.println("Xóa thành công");
                break;
            case 5:
                sapXepSanPham();
                System.out.println("Sắp xếp thành công");
                break;
            case 6:
                timSanPhamDatNhat();
                break;
            case 7:
                sanphams = readerAndWriter.read();
                break;
            case 8:
                readerAndWriter.write(sanphams);
                break;
            case 9:
                System.exit(0);
                break;
        }
    }

    //Case 1
    public void showSanPham(ArrayList<Sanpham> sanphams) {
        for (int i = 0; i < sanphams.size(); i++) {
            if ((i + 1) % 5 == 0) {
                System.out.println(sanphams.get(i));
                scanner.nextLine();
            } else {
                System.out.println(sanphams.get(i));
            }
        }
    }

    //Case 2
    public void themSanPham(Sanpham sanpham) {
        sanphams.add(sanpham);
    }

    public Sanpham taoSanPham() {
        int idSanPham = validateSanPham.validateIdSanPham(sanphams);
        String tenSanPham = validateSanPham.valiDateTenSanPham();
        float giaSanPham = validateSanPham.valiDateGiaSanPham();
        int soLuongSanPham = validateSanPham.valiDateSoLuongSanPham();
        System.out.println("Nhập mô tả: ");
        String moTaSanPham = scanner.nextLine();
        return new Sanpham(idSanPham, tenSanPham, giaSanPham, soLuongSanPham, moTaSanPham);
    }

    //Case 3
    public void capNhatSanPham() {
        while (true) {
            try {
                System.out.println("Nhập id sản phẩm: ");
                int id = Integer.parseInt(scanner.nextLine());
                int index = validateSanPham.getIndexSanPham(id, sanphams);
                if (index != -1) {
                    sanphams.set(index, taoSanPham());
                    return;
                } else {
                    System.err.println("Id không tồn tại");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại.");
            }
        }
    }

    //Case 4

    public void xoaSanPham() {
        while (true) {
            try {
                System.out.println("Nhập id muốn xóa: ");
                int id = Integer.parseInt(scanner.nextLine());
                int index = validateSanPham.getIndexSanPham(id, sanphams);
                if (index == -1) {
                    System.out.println("Không tìm thấy sản phẩm cần xóa");
                } else {
                    sanphams.remove(index);
                    return;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại");
            }
        }
    }

    //Case 5
    public void sapXepSanPham() {
        sanphams.sort(new SapXepSanPham());
    }

    //Case 6

    public void timSanPhamDatNhat() {
        float max = sanphams.get(0).getGiaSanPham();
        int index = 0;
        for (int i = 0; i < sanphams.size(); i++) {
            if (sanphams.get(i).getGiaSanPham() > max) {
                max = sanphams.get(i).getGiaSanPham();
                index = i;
            }
            System.out.println("Sản phẩm đắt nhất là : " + sanphams.get(index).getTenSanPham() + " có giá " + max);
        }
    }

}
