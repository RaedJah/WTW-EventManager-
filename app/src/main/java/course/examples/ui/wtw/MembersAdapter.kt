package course.examples.ui.wtw
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MembersAdapter(context: Context, private val members: MutableList<String>) :
    ArrayAdapter<String>(context, 0, members) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.item_member, parent, false)
        }

        val memberName = getItem(position) ?: ""
        val nameTextView = listItemView?.findViewById<TextView>(R.id.member_name)
        nameTextView?.text = memberName

        val removeButton = listItemView?.findViewById<Button>(R.id.remove_member_button)
        removeButton?.setOnClickListener {
            // Implement remove functionality
            remove(memberName)
            notifyDataSetChanged()
            Toast.makeText(context, "$memberName removed", Toast.LENGTH_SHORT).show()
        }

        return listItemView!!
    }
}
