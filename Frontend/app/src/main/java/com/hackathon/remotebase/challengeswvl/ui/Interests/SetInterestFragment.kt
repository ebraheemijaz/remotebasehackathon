package com.hackathon.remotebase.challengeswvl.ui.Interests

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hackathon.remotebase.challengeswvl.R
import com.hackathon.remotebase.challengeswvl.adapters.AllInterestsAdapter
import com.hackathon.remotebase.challengeswvl.utils.ConnectionLiveData
import com.hackathon.remotebase.challengeswvl.utils.SpacesItemDecoration
import com.hackathon.remotebase.challengeswvl.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_set_interests.*

@AndroidEntryPoint
class SetInterestFragment : Fragment() {

    private val viewModel: SetInterestsViewModel by viewModels()
    lateinit var connectionLiveData: ConnectionLiveData
    private var allInterestsAdapter: AllInterestsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_set_interests, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initGUI()

        listeners()

        connectionLiveData = ConnectionLiveData(requireContext())

        connectionLiveData.observe(
            viewLifecycleOwner, { isNetworkAvailable ->

                if (isNetworkAvailable) {
                    //do API Call
                    Toast.makeText(requireContext(), "Internet Now Connected..", Toast.LENGTH_SHORT)
                        .show();

                    observeInterests()
                } else {
                    //show No Internet error
                    Toast.makeText(requireContext(), "No Internet Connection", Toast.LENGTH_SHORT)
                        .show();
                }
            }

        )

    }

    private fun listeners() {

        btnSubmit?.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.actionSubmit)

        }
    }

    private fun initGUI() {
        allInterestsAdapter = AllInterestsAdapter {

            viewModel.postUserInterests()
        }
        rvInterests?.apply {
            adapter = allInterestsAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            SpacesItemDecoration(20)
        }
    }

    private fun observeInterests() {
        viewModel.allInterestsResponseDto.observe(
            viewLifecycleOwner, Observer { allInterestsResponseDto ->
                if (allInterestsResponseDto?.status == Status.LOADING) {
                    //show wait dialog

                    Log.d(
                        "SetInterestFragment",
                        "Loading"
                    )
                } else if (allInterestsResponseDto?.status == Status.SUCCESS) {
                    allInterestsResponseDto.data?.let { dto ->
                        allInterestsAdapter?.differ?.submitList(dto.InterstCategory)

                        Log.d(
                            "SetInterestFragment",
                            allInterestsResponseDto.data.InterstCategory.size.toString()
                        )
                    }
                    Log.d(
                        "SetInterestFragment",
                        allInterestsResponseDto.data?.InterstCategory?.size.toString()
                    )
                } else {
                    //show error message
                    Log.d(
                        "SetInterestFragment",
                        "Error"
                    )
                }
            }
        )
    }

}