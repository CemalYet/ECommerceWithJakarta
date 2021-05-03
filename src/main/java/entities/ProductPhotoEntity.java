package entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="productPhoto")
public class ProductPhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_photo")
    private int idPhoto;

    @Lob
    @Column(name="photoPath")
    private byte[] photo;

    @Column(name="photoOrder",nullable = false)
    private Byte photoOrder;

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setPhotoOrder(Byte photoOrder) {
        this.photoOrder = photoOrder;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Byte getPhotoOrder() {
        return photoOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPhotoEntity that = (ProductPhotoEntity) o;
        return idPhoto == that.idPhoto && photoOrder == that.photoOrder && Arrays.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idPhoto, photoOrder);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}
