package jlu.vending.entity;

/**
 * 商品实体类{@link Commodity}
 * 存储商品的id, name, price, number, state, picture
 */
public class Commodity {

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private Double price;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 状态: 0为上架 1为下架
     */
    private Integer state;

    /**
     * 图片地址
     */
    private String picture;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 重写toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", state=" + state +
                ", picture='" + picture + '\'' +
                '}';
    }
}