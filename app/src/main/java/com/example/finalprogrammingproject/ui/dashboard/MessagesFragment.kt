package com.example.finalprogrammingproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprogrammingproject.R
import com.example.finalprogrammingproject.databinding.FragmentMessagesBinding

class MessagesFragment : Fragment() {

    private lateinit var messagesRecyclerView: RecyclerView
    private var adapter: MessagesAdapter? = null

    private lateinit var dashboardViewModel: MessagesViewModel
    private var _binding: FragmentMessagesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(MessagesViewModel::class.java)

        _binding = FragmentMessagesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        messagesRecyclerView = root.findViewById(R.id.messages_recycler_view) as RecyclerView
        messagesRecyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private inner class MessageHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private lateinit var messages: MessagesViewModel

        private val pictureImageView: ImageView = itemView.findViewById(R.id.profilePic)
        val texts: TextView = itemView.findViewById(R.id.textMessages)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            //placeholder interaction
            Toast.makeText(context, "${messages.getTextMessage()} pressed!", Toast.LENGTH_SHORT)
                .show()
        }

        fun bind(messages: MessagesViewModel) {
            this.messages = messages
            texts.text = this.messages.getTextMessage()

           // pictureImageView.setImageResource(R.drawable.) //work with camera here
        }
    }

        private inner class MessagesAdapter(var messages: List<MessagesViewModel>) :
            RecyclerView.Adapter<MessageHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                    : MessageHolder {
                val view = layoutInflater.inflate(R.layout.item_messages, parent, false)
                return MessageHolder(view)
            }

            override fun onBindViewHolder(holder: MessageHolder, position: Int) {
                val theMessages = messages[position] //create array
                holder.bind(theMessages)
            }

            override fun getItemCount() = messages.size
            }


        private fun updateUI() {
            //val messages = MessagesViewModel
           // adapter = MessagesAdapter(messages)
           // messagesRecyclerView.adapter = adapter
        }

        companion object {
            fun newInstance(): MessagesFragment {
                return MessagesFragment()
            }
        }
    }
}