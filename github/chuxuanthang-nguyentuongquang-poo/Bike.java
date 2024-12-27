public abstract class Bike{
    protected String id;
    protected String type;
    /*protected boolean hasBasket;
    protected boolean hasCarrier;*/
    protected String status;
    protected int rentalCount;
    protected String event;
    protected String job;

    public Bike(String id, String type /* , boolean hasBasket, boolean hasCarrier*/, int rentalCount, String event, String job  ){
        this.id = id;
        this.type = type;
        /*this.hasBasket = hasBasket; 
        this.hasCarrier = hasCarrier; */
        this.status = "available";
        this.rentalCount = rentalCount;
        this.event = event;
        this.job = job;
    }


    // Constructor for ElectricBike
    public Bike(String id, String type, int initialBatteryLevel, int rentalCount) {
    }
    // Constructor for RegularBike/TraditionalBike 
    public Bike(String id, String type, int rentalCount) {
    }



    public String getId(){
        return id;
    }

    public String getType(){
        return type;
    }

    /*public boolean hasBasket(){
        return hasBasket;
    }

    public boolean hasCarrier(){
        return hasCarrier;
    }
        */

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public int getRentalCount(){
        return rentalCount;
    }

    public void incrementRentalCount(){
        this.rentalCount++;
    }

    public String getEvent(){
        return event;
    }

    public void setEvent(String event){
        this.event = event;
    }

    public String getJob(){
        return job;
    }

    public void setJob(String Job){
        this.job = Job;
    }

    public boolean needsMaintenance() {
        return rentalCount > 100;
    }
    public abstract void accept(IBikeVisitor visitor);

    @Override
    public String toString(){
        return "Bike{id ='" + id + "', type= '" + type +/* "', hasBasket='" + hasBasket +*/ "', status ='" + status +"', rentalCount=" + rentalCount + ", event='" + event + "', Job='" + job +  "'}";
    }
}