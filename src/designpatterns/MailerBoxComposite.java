package designpatterns;

public class MailerBoxComposite implements Box,Mailer{
	private Box box;
	
	public MailerBoxComposite(Box box) {
		this.box = box;
	}
	
	@Override
	public void addPostage() {
		System.out.println("affix stamps");
	}

	@Override
	public void ship() {
		System.out.println("put in mailbox");
	}

	@Override
	public void pack() {
		box.pack();
	}

	@Override
	public void seal() {
		box.seal();
	}
	
}

interface Box{
	void pack();
	void seal();
}
interface Mailer{
	void addPostage();
	void ship();
}