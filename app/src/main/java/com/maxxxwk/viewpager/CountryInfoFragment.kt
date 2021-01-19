package com.maxxxwk.viewpager

import android.os.Bundle
import android.text.SpannableString
import android.text.style.SuperscriptSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maxxxwk.viewpager.databinding.CountryInfoFragmentBinding

class CountryInfoFragment : Fragment() {

    private lateinit var binding: CountryInfoFragmentBinding

    companion object {
        private const val COUNTRY_KEY = "COUNTRY_KEY"
        fun newInstance(country: Country): CountryInfoFragment {
            val fragment = CountryInfoFragment()
            fragment.arguments = Bundle().apply {
                putParcelable(COUNTRY_KEY, country)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CountryInfoFragmentBinding.inflate(inflater, container, false)
        arguments?.let { bundle ->
            bundle.getParcelable<Country>(COUNTRY_KEY)?.let { country ->
                updateView(country)
            }
        }
        return binding.root
    }

    private fun updateView(country: Country) {
        binding.tvCountryName.text = country.name
        binding.tvCountryPopulation.text = getString(R.string.population_text, country.population)
        binding.tvCountrySquare.text = getString(R.string.square_text, country.square)
        binding.tvPopulationDensity.text =
            getString(R.string.population_density_text, country.populationDensity)
    }
}