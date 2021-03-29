package tw.tcnr12.m1501

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class M1501 : AppCompatActivity() {
    private var sf: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m1501)
        // 在FrameLayout新增Fragment片段
        val ff = FirstFragment() // 建立片段物件
        // 取得FragmentManager物件
        val fm = supportFragmentManager

// 開始執行片段管理的交易
        val trans = fm.beginTransaction()
        trans.add(R.id.frame, ff) // 新增片段
        trans.commit() // 確認交易
        //
    }

    // Button元件的事件處理
    fun button_Click(v: View?) {
// 取代成第2個片段
        sf = SecondFragment.Companion.newInstance("改成第二個Fragment片段")
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, sf as SecondFragment)
            .commit()
    }

    fun button2_Click(v: View?) {
// 刪除第2個片段
        supportFragmentManager
            .beginTransaction()
            .remove(sf!!)
            .commit()
    } // if (getSupportFragmentManager() !=null) {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_settings->finish()
        }
        return super.onOptionsItemSelected(item)
    }
}