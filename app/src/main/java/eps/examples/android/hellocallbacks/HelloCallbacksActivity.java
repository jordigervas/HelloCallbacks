package eps.examples.android.hellocallbacks;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class HelloCallbacksActivity extends Activity {

    private static final String LIVECYCLE_STATE = "LivecycleState";
    private TextView myView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_callbacks);

        myView = (TextView) findViewById(R.id.textview);
        if (savedInstanceState==null) {
            if (myView != null)
                myView.append(getString(R.string.onCreateCallback));
        }
        else {
            // Restore TextView state.
            if (myView != null) {
                myView.setText(savedInstanceState.getCharSequence(LIVECYCLE_STATE));
                myView.append(getString(R.string.onCreateCallback));
            }
        }
    }


    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (myView!=null)
            myView.append(getString(R.string.onPostCreateCallback));
    }

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        TextView myView = (TextView) findViewById(R.id.textview);
        if (myView!=null)
            myView.append(getString(R.string.onStartCallback));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (myView!=null)
            outState.putCharSequence(LIVECYCLE_STATE, myView.getText());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // The activity is about to become visible.
        TextView myView = (TextView) findViewById(R.id.textview);
        if (myView!=null)
            myView.append(getString(R.string.onRestartCallback));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        TextView myView = (TextView) findViewById(R.id.textview);
        if (myView!=null)
            myView.append(getString(R.string.onResumeCallback));
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
        TextView myView = (TextView) findViewById(R.id.textview);
        if (myView!=null)
            myView.append(getString(R.string.onPauseCallback));
    }

    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        TextView myView = (TextView) findViewById(R.id.textview);
        if (myView!=null)
            myView.append(getString(R.string.onStopCallback));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        TextView myView = (TextView) findViewById(R.id.textview);
        if (myView!=null)
            myView.append(getString(R.string.onDestroyCallback));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_callbacks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
