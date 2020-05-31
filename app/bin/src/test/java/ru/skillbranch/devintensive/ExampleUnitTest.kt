package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extentions.TimeUnits
import ru.skillbranch.devintensive.extentions.add
import ru.skillbranch.devintensive.extentions.format
import ru.skillbranch.devintensive.extentions.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Wick")

    }

    @Test
    fun test_factory() {
//        val user = User.makeUser("John Cena")
        val user = User.makeUser("John Wick")
//        val user3 = User.makeUser(" ")
        val user2 = user.copy(id = "2", lastName = "Cena", lastVisit = Date())
        print(user2)

    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")

    }


    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(id = "2", lastVisit = Date())
        val user3 = user.copy(lastName = "Cena", lastVisit = Date().add(-3, TimeUnits.HOUR))

//        if (user.equals(user2)) {
//            println("equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
//        } else {
//            println("not equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
//        }
//
//        if (user === user2) {
//            println("equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        } else {
//            println("not equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        }

        println(user2.lastVisit?.format())
        println(user3.lastVisit?.format())

    }

    @Test
    fun test_data_mapping() {
        val user = User.makeUser("Иванов Иван")
        val newUser = user.copy(lastVisit = Date().add(-40, TimeUnits.SECOND))
        println(newUser)

        val userView = user.toUserView()
        userView.printMe()

        val userView2 = newUser.toUserView()
        userView2.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Иванов Иван")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "Any text message", type = "text")
        val imageMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "Any image url", type = "image")

        println(txtMessage.formatMessage())
        println(imageMessage.formatMessage())
    }

}
