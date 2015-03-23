package entity;

public class Entity implements IEntity {
	private double brutto;
	private double tara;
	private boolean RM20;
	private String mainDisplay = "";
	private String secDisplay = "";
		
	public Entity() {
		brutto = 0.000;
		tara = 0.000;
		RM20 = false;
		
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
	
	@Override
	public boolean getRM20() {
		return RM20;
	}

	@Override
	public void setRM20(boolean RM20) {
		this.RM20 = RM20;
	}

	@Override
	public void setText(String text) {
		mainDisplay = text;
		
	}

	@Override
	public String getText() {
		return mainDisplay;
	}

	public String getSecDisplay() {
		return secDisplay;
	}

	public void setSecDisplay(String secDisplay) {
		this.secDisplay = secDisplay;
	}
}
