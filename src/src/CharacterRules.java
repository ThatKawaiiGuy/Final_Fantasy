package src;

public class CharacterRules {
	public int userHealth;
	public int enemyHealth;
	public int value;

	public CharacterRules(int pHealth, int eHealth) {
		userHealth = pHealth;
		enemyHealth = eHealth;
	}

	public void damageEnemy(int value2) {
		value = value2;
		enemyHealth -= value;
		if (enemyHealth <= 0) {
			enemyHealth = 0;
			End end = new End(true);
		}
	}

	public void damagePlayer(int value2) {
		value = value2;
		userHealth -= value;
		if (userHealth <= 0) {
			userHealth = 0;
			End end = new End(false);
		}

	}

	public void healPlayer(int value2) {
		value = value2;
		userHealth -= value;
		if (userHealth > 512)
			userHealth = 512;
	}

	public int getPlayerHealth() {
		return userHealth;
	}

	public int getEnemyHealth() {
		return enemyHealth;
	}

}