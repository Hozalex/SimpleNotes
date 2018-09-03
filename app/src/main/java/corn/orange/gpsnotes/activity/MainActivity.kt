package corn.orange.gpsnotes.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import corn.orange.gpsnotes.R
import corn.orange.gpsnotes.adapter.NoteAdapter
import corn.orange.gpsnotes.persistence.Note
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.view.*

class MainActivity : AppCompatActivity()
{

    private lateinit var notesArrayList: ArrayList<Note>
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initVariables()
        Log.d(TAG, notesArrayList[0].getTitle() + " " + notesArrayList[0].getContent())
        setSupportActionBar(my_toolbar)
        addAdapter()

    }

    //initialization variables
    private fun initVariables()
    {
        notesArrayList = ArrayList(10)
    }

    //add recycler view to activity
    private fun addAdapter()
    {
        //create adapter and set it to recycler view
        rvNotes.adapter = NoteAdapter(notesArrayList, object : NoteAdapter.OnNoteClickListener
        {
            override fun onNoteClick(notePosition: Int)
            {
                Toast.makeText(applicationContext, "Click Note", Toast.LENGTH_SHORT).show()
            }
        })
        //recycler view settings
        rvNotes.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(rvNotes.context)
        }
    }

    //create menu on app bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        //inflate menu from main_menu
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //set up press on the menu button
    override fun onOptionsItemSelected(item: MenuItem?): Boolean
    {
        when (item?.itemId)
        {
            R.id.menu_add_note -> Toast.makeText(this, "add note", Toast.LENGTH_SHORT).show()
            R.id.menu_clear_note -> Toast.makeText(this, "add clear note", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


}
