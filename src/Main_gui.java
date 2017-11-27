
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;

public class Main_gui {
  String path; 
  public void setPath(String path) 
  {
	  this.path = path;
  }
  public String getPath() 
  {
	  return path;
  }
	
	
Display d;

  Shell s;
  private Text txtOutput;

  Main_gui() {
	  //basic construct initialize the gui
    d = new Display();
    s = new Shell(d,SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX);
    //auto quit the gui when red x pressed
    s.addListener(SWT.CLOSE, new Listener() 
    {
    	   public void handleEvent(Event e)
    	   {
    		   s.setVisible(false);
    	   }
    	});
   
    s.setSize(412, 400);
    GridLayout gl_s = new GridLayout(3, false);
    gl_s.horizontalSpacing = 3;
    
    Tree tree = new Tree(s, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION);
    GridData gd_tree = new GridData(SWT.LEFT, SWT.FILL, true, true, 1, 1);
    gd_tree.heightHint = 59;
    gd_tree.widthHint = 83;
    tree.setLayoutData(gd_tree);
    Label imageField = new Label(s, SWT.NONE);
    imageField.addControlListener(new ControlAdapter() {
    	@Override
    	public void controlResized(ControlEvent e) {
    		
    		  try 
    	        {
    			  	String selected = getPath();
    	            Image image = SWTResourceManager.getImage(selected);
    	            ImageData imgData = image.getImageData();
    	            imgData = imgData.scaledTo(imageField.getBounds().width, imageField.getBounds().height);
    	            ImageLoader imgLoader = new ImageLoader();
    	            imgLoader.data = new ImageData[] {imgData};
    	            imgLoader.save(selected, SWT.IMAGE_COPY);
    	            imageField.setBounds(imageField.getBounds().x,imageField.getBounds().y,imageField.getBounds().width,
    	            						imageField.getBounds().height);
    	            imageField.setImage(SWTResourceManager.getImage(selected));
    	            
    	           	}
    	        catch(Exception e1) 
    	        {
    	        	 System.out.println(e1);
    	        }
    	        
    		
    		System.out.println(e);
    	}
    });
    GridData gd_lblNewLabel = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
    gd_lblNewLabel.widthHint = 186;
    gd_lblNewLabel.heightHint = 261;
    imageField.setLayoutData(gd_lblNewLabel);
    
    txtOutput = new Text(s, SWT.BORDER);
    txtOutput.setText("OUT_PUT");
    GridData gd_txtOutput = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
    gd_txtOutput.widthHint = 106;
    gd_txtOutput.heightHint = 16;
    txtOutput.setLayoutData(gd_txtOutput);

Button btnNewButton = new Button(s, SWT.NONE);
btnNewButton.addSelectionListener(new SelectionAdapter() {
	@Override
	public void widgetSelected(SelectionEvent e) {
	}
});

btnNewButton.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
btnNewButton.setText("Test");
    new Label(s, SWT.NONE);
    
    
    Button btnNewButton_1 = new Button(s, SWT.NONE);
    btnNewButton_1.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    	}
    });
    btnNewButton_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
    btnNewButton_1.setText("Reset");

    s.setLayout(gl_s);
    s.open();
    
    s.setText("CTN_GUI");
    //         create the menu system
    Menu m = new Menu(s, SWT.BAR);
    // create a file menu and add an exit item
    final MenuItem file = new MenuItem(m, SWT.CASCADE);
    file.setText("&File");
    final Menu filemenu = new Menu(s, SWT.DROP_DOWN);
    file.setMenu(filemenu);
    final MenuItem openItem = new MenuItem(filemenu, SWT.PUSH);
    openItem.setText("&Open\tCTRL+O");
    openItem.setAccelerator(SWT.CTRL + 'O');
    final MenuItem saveItem = new MenuItem(filemenu, SWT.PUSH);
    saveItem.setText("&Save\tCTRL+S");
    saveItem.setAccelerator(SWT.CTRL + 'S');
    final MenuItem separator = new MenuItem(filemenu, SWT.SEPARATOR);
    final MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);
    exitItem.setText("E&xit");

    class Open implements SelectionListener {
      public void widgetSelected(SelectionEvent event) {
        FileDialog fd = new FileDialog(s, SWT.OPEN);
        fd.setText("Open");
        fd.setFilterPath("C:/");
        String[] filterExt = {  "*.*","*.txt", "*.doc", ".rtf"};
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        setPath(selected);
        System.out.println(selected);
        try 
        {
            Image image = SWTResourceManager.getImage(selected);
            ImageData imgData = image.getImageData();
            imgData = imgData.scaledTo(imageField.getBounds().width, imageField.getBounds().height);
            ImageLoader imgLoader = new ImageLoader();
            imgLoader.data = new ImageData[] {imgData};
            imgLoader.save(selected, SWT.IMAGE_COPY);
            imageField.setBounds(imageField.getBounds().x,imageField.getBounds().y,imageField.getBounds().width,
            						imageField.getBounds().height);
            imageField.setImage(SWTResourceManager.getImage(selected));
            
           	}
        catch(Exception e) 
        {
        	 System.out.println(e);
        }
        
      }

      public void widgetDefaultSelected(SelectionEvent event) {
    	      System.out.println("hello");
      }
    }

    class Save implements SelectionListener {
      public void widgetSelected(SelectionEvent event) {
        FileDialog fd = new FileDialog(s, SWT.SAVE);
        fd.setText("Save");
        fd.setFilterPath("C:/");
        String[] filterExt = { "*.*", "*.txt", "*.doc", ".rtf" };
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        
        System.out.println(selected);
      }

      public void widgetDefaultSelected(SelectionEvent event) {
      }
    }
    openItem.addSelectionListener(new Open());
    saveItem.addSelectionListener(new Save());

    exitItem.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        MessageBox messageBox = new MessageBox(s, SWT.ICON_QUESTION
            | SWT.YES | SWT.NO);
        messageBox.setMessage("Do you really want to exit?");
        messageBox.setText("Exiting Application");
        int response = messageBox.open();
        if (response == SWT.YES)
          System.exit(0);
      }
    });
    s.setMenuBar(m);
    
 
    


    while (!s.isDisposed()) {
      if (!d.readAndDispatch())
        d.sleep();
    }
    d.dispose();
  }
  

  public static void main(String[] argv) {
    new Main_gui();
  }
}
