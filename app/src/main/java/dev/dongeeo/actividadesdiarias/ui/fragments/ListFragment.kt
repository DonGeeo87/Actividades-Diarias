package dev.dongeeo.actividadesdiarias.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.asLiveData
import androidx.navigation.fragment.findNavController
import dev.dongeeo.actividadesdiarias.R
import dev.dongeeo.actividadesdiarias.databinding.FragmentListBinding
import dev.dongeeo.actividadesdiarias.ui.AboutActivity
import dev.dongeeo.actividadesdiarias.ui.adapter.ActivityAdapter
import dev.dongeeo.actividadesdiarias.viewmodel.ActivityViewModel
import dev.dongeeo.actividadesdiarias.viewmodel.ViewModelFactory

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ActivityViewModel by activityViewModels {
        ViewModelFactory(requireContext().applicationContext)
    }

    private val adapter = ActivityAdapter { activityId ->
        viewModel.toggleActivityCompleted(activityId)
    }
    private var cachedName: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        binding.toolbar.setNavigationOnClickListener {
            val intent = Intent(requireActivity(), AboutActivity::class.java).apply {
                putExtra(AboutActivity.EXTRA_USER_NAME, cachedName)
            }
            startActivity(intent)
        }

        binding.rvActivities.adapter = adapter

        // Observa las actividades en LiveData para actualizar el RecyclerView en tiempo real
        viewModel.activities.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.llEmpty.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
            binding.rvActivities.visibility = if (list.isEmpty()) View.GONE else View.VISIBLE
        }

        // Observa el nombre del usuario desde DataStore (Flow -> LiveData)
        viewModel.userName.asLiveData().observe(viewLifecycleOwner) { name ->
            cachedName = name.orEmpty()
            binding.tvGreeting.text = if (cachedName.isNotBlank()) {
                "Hola, $cachedName 👋"
            } else {
                "Hola 👋"
            }
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

