package entity;

public class Entity implements IEntity {
	private double brutto;
	private double tara;
		
	public Entity() {
		brutto = 0.0;
		tara = 0.0;
	}

	/* (non-Javadoc)
	 * @see entity.IEntity#getBrutto()
	 */
	@Override
	public double getBrutto() {
		return brutto;
	}


	/* (non-Javadoc)
	 * @see entity.IEntity#setBrutto(double)
	 */
	@Override
	public void setBrutto(double brutto) {
		this.brutto = brutto;
	}


	/* (non-Javadoc)
	 * @see entity.IEntity#getTara()
	 */
	@Override
	public double getTara() {
		return tara;
	}


	/* (non-Javadoc)
	 * @see entity.IEntity#setTara(double)
	 */
	@Override
	public void setTara(double tara) {
		this.tara = tara;
	}
}
