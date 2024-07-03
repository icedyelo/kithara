package kithara.model;

public class ProductModel {

    private int ProductsId;
    private String ProductsName;
    private String Description;
    private String Size;
    private double Price;
    private int Quantity;

    public ProductModel() {
        //Set as empty
    }
    

    public ProductModel(
            int ProductsId,
            String ProductsName,
            String Description,
            String Size,
            double Price,
            int Quantity) {
        this.ProductsId = ProductsId;
        this.ProductsName = ProductsName;
        this.Description = Description;
        this.Size = Size;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public int getproductsId() {
        return ProductsId;
    }

    public void setproductsId(int ProductsId) {
        this.ProductsId = ProductsId;
    }

    public String getproductsName() {
        return ProductsName;
    }

    public void setproductsName(String ProductsName) {
        this.ProductsName = ProductsName;
    }

    public String getdescription() {
        return Description;
    }

    public void setdescription(String Description) {
        this.Description = Description;
    }

    public String getsize() {
        return Size;
    }

    public void setsize(String Size) {
        this.Size = Size;
    }

    public double getprice() {
        return Price;
    }

    public void setprice(double Price) {
        this.Price = Price;
    }

    public int getquantity() {
        return Quantity;
    }

    public void setquantity(int Quantity) {
        this.Quantity = Quantity;
    }

}
