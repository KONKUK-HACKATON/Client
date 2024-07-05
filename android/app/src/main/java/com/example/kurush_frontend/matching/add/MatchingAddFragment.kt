package com.example.kurush_frontend.matching.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.kurush_frontend.R
import com.example.kurush_frontend.data.request.LoginRequest
import com.example.kurush_frontend.data.request.MatchingAddRequest
import com.example.kurush_frontend.data.response.LoginResponse
import com.example.kurush_frontend.data.response.MatchingAddResponse
import com.example.kurush_frontend.databinding.FragmentMatchingAddBinding
import com.example.kurush_frontend.matching.main.MatchingMainFragment
import com.example.kurush_frontend.retrofit.RetrofitObject
import com.example.kurush_frontend.retrofit.retrofit_if.RetrofitIF
import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MatchingAddFragment : Fragment() {
    private val BASE_URL = "http://13.125.122.128:8080"
    lateinit var bundle: Bundle

    lateinit var binding : FragmentMatchingAddBinding
    lateinit var matchAddRequest : MatchingAddRequest

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bundle = Bundle()
        binding = FragmentMatchingAddBinding.inflate(layoutInflater, container, false)
        setupSpinner()

        binding.ivMatchingAddBack.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MatchingMainFragment())
                .commit()
        }

        binding.ivMatchingAddBtn.setOnClickListener {
            //TODO : Post 기능 추가
            initRetrofit()

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MatchingMainFragment())
                .commit()
        }



        return binding.root
    }

    private fun initRetrofit() {

        val service = RetrofitObject.retrofit.create(RetrofitIF::class.java)

        matchAddRequest = bundle.getString("gender")?.let {
            MatchingAddRequest(
                binding.etMatchingAddNickname.text.toString(),
                binding.etMatchingAddCountry.text.toString(),
                it,
                bundle.getString("college")!!,
                bundle.getString("department")!!
            )
        }!!

        service.addMatchingList(
            matchAddRequest
        ).enqueue(object : Callback<MatchingAddResponse> {
            override fun onResponse(
                call: Call<MatchingAddResponse>,
                response: Response<MatchingAddResponse>
            ) {
                if(response.isSuccessful){
                    val result = response.body()
                    if (result!=null){
                        Log.d("result", result.toString())
                    }
                    }else{
                        Log.d("res", response.toString())
                }
            }

            override fun onFailure(call: Call<MatchingAddResponse>, t: Throwable) {
                Log.d("err", "err")
            }

        })


    }

    private fun setupSpinner() {
        val spnCollege : Spinner = binding.spnMatchingAddCollege
        val spnDepartment : Spinner = binding.spnMatchingAddDepartment
        val spnGender : Spinner = binding.spnMatchingAddGender

        val collegeItems = arrayOf("문과대학", "이과대학", "건축대학","공과대학","사회과학대학","경영대학","부동산과학원","KU융합과학기술원","상허생명과학대학")
        val departmentItems = arrayOf(
            arrayOf("문학과", "사학과", "언어정보학과"), // 문과대학
            arrayOf("수학과", "물리학과", "화학과"), // 이과대학
            arrayOf("건축학과", "토목공학과", "기계공학과"), // 건축대학
            arrayOf("컴퓨터공학부", "전기전자공학부", "기계공학부"), // 공과대학
            arrayOf("사회학과", "심리학과", "경제학과"), // 사회과학대학
            arrayOf("경영학과", "회계학과", "마케팅학과"), // 경영대학
            arrayOf("부동산학과", "도시계획학과", "건축도시시스템공학과"), // 부동산과학원
            arrayOf("융합기술과학학부", "에너지화학공학과", "바이오나노학부"), // KU융합과학기술원
            arrayOf("생명과학과", "식물생산과학과", "생명공학과") // 상허생명과학대학
        )
        val genderItems = arrayOf("남", "여")

        val collegeAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, collegeItems)
        spnCollege.adapter = collegeAdapter
        var selectedCollegeIndex : Int
        var selectedDepartmentIndex : Int
        var selectedGenderIndex : Int

        val genderAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, genderItems)
        spnGender.adapter = genderAdapter

        // 스피너 선택 이벤트 처리
        spnCollege.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                // 선택된 대학에 해당하는 학부 목록을 가져옵니다.
                selectedCollegeIndex = parent?.selectedItemPosition ?: 0
                val selectedDepartments = departmentItems[selectedCollegeIndex]

                // 해당 학부 목록으로 ArrayAdapter를 생성하고 스피너에 설정합니다.
                val departmentAdapter = ArrayAdapter(requireContext(), R.layout.item_spinner, selectedDepartments)
                spnDepartment.adapter = departmentAdapter

                spnDepartment.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        selectedDepartmentIndex = parent?.selectedItemPosition ?: 0


                        bundle.putString("college", collegeItems[selectedCollegeIndex])
                        bundle.putString("department", selectedDepartments[selectedDepartmentIndex])
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spnGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                selectedGenderIndex = parent?.selectedItemPosition ?: 0
                bundle.putString("gender", genderItems[selectedGenderIndex])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }
}