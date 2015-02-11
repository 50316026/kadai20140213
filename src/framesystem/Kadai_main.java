package framesystem;

public class Kadai_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSystemController controller=new
		FrameSystemController();
		FrameSystemView frame=new
		FrameSystemView(controller);		
		frame.setBounds(5,5,1280,720);
		frame.setVisible(true);
	}
}
