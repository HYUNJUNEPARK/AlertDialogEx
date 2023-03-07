package com.study.customex

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * https://developer-eungb.tistory.com/12 -> [Android/Kotlin] 안드로이드 BottomSheetDialogFragment 구현하기
 * https://www.crocus.co.kr/1749 -> Android BottomSheetDialog 크기 조절하기
 */
class BottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_bottom_sheet, container, false)
        val btn: Button = view.findViewById(R.id.button_bottom_sheet)
        btn.setOnClickListener {
            Toast.makeText(requireContext(), "asdfasdf", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        return view
    }

    /**
     *
    참고 Behavior 상태
    STATE_EXPANDED : 완전히 펼쳐진 상태
    STATE_COLLAPSED : 접혀있는 상태
    STATE_HIDDEN : 아래로 숨겨진 상태
    STATE_HALF_EXPANDED : 절반으로 펼쳐진 상태
    STATE_DRAGGING : 드래깅 되고 있는 상태
    STATE_SETTING : 드래그/스와이프 직후 고정된 상태
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 팝업 생성 시 전체화면으로 띄우기
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        val behavior = BottomSheetBehavior.from<View>(bottomSheet!!)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        // 드래그해도 팝업이 종료되지 않도록
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }
}