import java.util.ArrayList;

public class TestApplication {
	public static void main(String[] args) {
		ArrayList<Card> kortArray = new ArrayList<>();
		Card k1 = new Ansatt("Ole", "Olsen");
		Card k2 = new Gjest("Marit", "Olsen");
		kortArray.add(k1);
		kortArray.add(k2);
		for (Card kort : kortArray) {
			System.out.println(kort);
			System.out.println("Kode 1234 er " + (kort.checkPin("1234") ? "gyldig" : "ugyldig"));
			System.out.println("Kode 9999 er " + (kort.checkPin("9999") ? "gyldig" : "ugyldig"));
			System.out.println("Koden er : " + kort.pinCode);
		}
	}
}

