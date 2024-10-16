package labTwoClasses;

public class Car {
    private int id;
    private String model;
    private int manufactureYear;
    private int price;
    private int registrationNumber;
    
    /**
     * Конструктор для створення об'єкта Car.
     * 
     * @param id Ідентифікатор машини
     * @param model Модель машини
     * @param manufactureYear Рік випуску машини
     * @param price Ціна машини
     * @param registrationNumber Реєстраційний номер машини
     */
    public Car(int id, String model, int manufactureYear, int price, int registrationNumber){
        this.id = id;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }
    
    /**
     * @return ідентифікатор машини
     */
    public int getId() { return id; }
    
    /**
     * Встановлює ідентифікатор машини.
     * 
     * @param id новий ідентифікатор
     */
    public void setId(int id) { this.id = id; }
    
    /**
     * @return модель машини
     */
    public String getModel() { return model; }
    
    /**
     * Встановлює модель машини.
     * 
     * @param model нова модель
     */
    public void setModel(String model) { this.model = model; }
    
    /**
     * @return рік випуску машини
     */
    public int getManufactureYear() { return manufactureYear; }
    
    /**
     * Встановлює рік випуску машини.
     * 
     * @param manufactureYear новий рік випуску
     */
    public void setManufactureYear(int manufactureYear) { this.manufactureYear = manufactureYear; }
    
    /**
     * @return ціна машини
     */
    public int getPrice() { return price; }
    
    /**
     * Встановлює ціну машини.
     * 
     * @param price нова ціна
     */
    public void setPrice(int price) { this.price = price; }
    
    /**
     * @return реєстраційний номер машини
     */
    public int getRegistrationNumber() { return registrationNumber; }
    
    /**
     * Встановлює реєстраційний номер машини.
     * 
     * @param registrationNumber новий реєстраційний номер
     */
    public void setRegistrationNumber(int registrationNumber) { this.registrationNumber = registrationNumber; }
    
    /**
     * Виводить інформацію про машину.
     */
    public void outputCarData() {
        System.out.println("ID = " + this.getId() + ", Модель = " + this.getModel() + ", Рік випуску = " + this.getManufactureYear() + ", Ціна = " + this.getPrice() + ", Реєстраційний номер = " + this.getRegistrationNumber());
    }
}
