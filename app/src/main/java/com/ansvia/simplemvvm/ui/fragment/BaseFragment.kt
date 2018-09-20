package com.ansvia.simplemvvm.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ansvia.simplemvvm.ui.BaseActivity


abstract class BaseFragment : Fragment() {

    protected var mView: View? = null
    protected var mContext: Context? = null

    private val interaction by lazy { activity as BaseActivity }
    protected val fab by lazy { interaction.getFab() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected fun inflateView(context: Context, inflater: LayoutInflater, container: ViewGroup, layoutId: Int): View? {
        mContext = context
        mView = inflater.inflate(layoutId, container, false)
        return mView
    }
}
