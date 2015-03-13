package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener( ) ;
	
	final private int[ ] imageButtonIds = {
			R.id.imageButton1,
			R.id.imageButton2,
			R.id.imageButton3
	} ;
	
	final private int[ ] buttonIds = {
			R.id.button0,
			R.id.button1,
			R.id.button2,
			R.id.button3,
			R.id.button4,
			R.id.button5,
			R.id.button6,
			R.id.button7,
			R.id.button8,
			R.id.button9,
			R.id.button10,
			R.id.button11
	} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        for ( int i = 0 ; i < imageButtonIds.length ; i++ )
        {
        	ImageButton imageButton = ( ImageButton ) findViewById ( imageButtonIds[ i ] ) ;
        	imageButton.setOnClickListener( buttonClickListener ) ;
        }
        for ( int i = 0 ; i < buttonIds.length ; i++ )
        {
        	Button button = ( Button ) findViewById ( buttonIds[ i ] ) ;
        	button.setOnClickListener( buttonClickListener ) ;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    protected class ButtonClickListener implements View.OnClickListener
    {
		@Override
		public void onClick(View v) {
			EditText et = ( EditText ) findViewById ( R.id.editText1 ) ;
			if ( v instanceof Button )
			{
				et.setText( et.getText( ) + ( ( ( Button ) v ).getText( ).toString( ) ) ) ;				
			}
			else
			{
				if ( ( ( ImageButton ) v ).getId( ) == R.id.imageButton1 )
				{
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:"+et.getText().toString()));
					startActivity(intent);
				}
				else if ( ( ( ImageButton ) v ).getId( ) == R.id.imageButton2 )
				{
					finish (  ) ;
				}
				else if ( ( ( ImageButton ) v ).getId( ) == R.id.imageButton3 )
				{
					if ( et.getText().length() > 0 )
					{
						String text = et.getText( ).toString( ) ;
						text = text.substring( 0, text.length( ) - 1 ) ;
						et.setText( text ) ;
					}
				}
			}
		}	
    }
}
