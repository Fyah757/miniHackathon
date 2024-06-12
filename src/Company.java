public class Company {
    private int index;
    private String organizationId;
    private String salesRepId;
    private String name;
    private String website;
    private String country;
    private String description;
    private String founded;
    private String industry;
    private int numberOfEmployees;

    public Company() {
    }



    public Company (int index, String organizationId, String salesRepId, String name, String website, String country, String description,
                    String founded, String industry, int numberOfEmployees){
        this.index = index;
        this.organizationId = organizationId;
        this.salesRepId = salesRepId;
        this.name = name;
        this.website = website;
        this.country = country;
        this.description = description;
        this.founded = founded;
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
    }
    @Override
    public String toString() {
        return "Company{" +
                "organizationId='" + organizationId + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", industry='" + industry + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(String salesRepId) {
        this.salesRepId = salesRepId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
