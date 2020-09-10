package Kafka.KafkaSpringBoot;

public class MessageSample {
    private String firstName;
    private String lastName;
    private int age;
    private String handledTimestamp;

    public MessageSample() {
        super();
    }

    public MessageSample(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHandledTimestamp() {
        return handledTimestamp;
    }

    public void setHandledTimestamp(String handledTimestamp) {
        this.handledTimestamp = handledTimestamp;
    }

    @Override
    public String toString() {
        return "MessageSample{" +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", age = " + age +
                ", handledTimestamp = " + handledTimestamp +
                '}';
    }
}
