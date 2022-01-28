package javaCLASS;

public class Wrestler {
	
	private double weight;
	private int numberofwins;
	private String name;
	private String outfitcolor;

	public Wrestler(String n, String oc, double weight, int numberofwins) {
		this.numberofwins = numberofwins;
		this.weight = weight;
		name = n;
		outfitcolor = oc;
	}
	
	public double getWeight() {
		return weight;
	}
	public void intimidate() {
		System.out.print("i'm going to beat you up");
	}
	
	
	public boolean fight(Wrestler other) {
		if(weight > other.weight){
			numberofwins ++;
			System.out.print(name + "wins");
			return true;
		}
		else if(weight < other.weight) {
			other.numberofwins ++;
			System.out.print(name + "wins");
			return false;
		}
		else{
			if(name.compareToIgnoreCase(other.name)< 0){
				numberofwins++;
				return true;
			}
			else {
				other.numberofwins++;
				return false;
			}
		}	
	}
	
	public void lift(int mins) {
		weight += .1*mins;
	}
	
	public boolean tagTeam(Wrestler[] allies, Wrestler[] opponents) {
		double allyWeight = weight, enemyWeight = 0;
		
		for(Wrestler w: allies) {
			w.outfitcolor = outfitcolor;
			allyWeight += w.weight;
		}
		for(int i = 0; i < opponents.length; i++) {
			opponents[i].outfitcolor = opponents[0].outfitcolor;
			enemyWeight += opponents[i].weight;
		}
		
		if(allyWeight >= enemyWeight) {
			numberofwins++;
			for(Wrestler w: allies) {
				w.numberofwins++;
			}
			return true;
		}
		else {
			for(Wrestler w: opponents) {
				w.numberofwins++;
			}
			return false;
		}
	}

	public String toString() {
		return name + "weighs " + weight + " pounds, is wearing a " + outfitcolor + "outfit, and has " + numberofwins + " wins";
	}
	
	public static void main(String[] args) {
		Wrestler m = new Wrestler("Mare", "blue", 220, 25);
		Wrestler j = new Wrestler("jojo", "red", 225, 26);
		Wrestler jo = new Wrestler("joey", "orange", 330, 12);
		Wrestler w = new Wrestler("will", "green", 200, 10);
		Wrestler l = new Wrestler("will", "green", 200, 10);
		
		Wrestler[] allies = {l,j};
		Wrestler[] opponents = {jo,w};
		
		m.intimidate();
		System.out.println(m.fight(j));
		m.lift(100);
		System.out.println(m.tagTeam(allies,opponents));
		
		System.out.println(m);
	}

}
