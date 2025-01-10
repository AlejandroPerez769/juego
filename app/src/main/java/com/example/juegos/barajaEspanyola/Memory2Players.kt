package com.example.juegos.barajaEspanyola

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentMemory2PlayersBinding
import com.example.juegos.databinding.FragmentMemoryBinding


class Memory2Players : Fragment() {

    private var _binding: FragmentMemory2PlayersBinding? = null
    private val binding get() = _binding!!

    val cartas = arrayOf(
        Carta("Espada", 11, R.drawable._1_espadas),
        Carta("Basto", 10, R.drawable._0_bastos),
        Carta("Copa", 12, R.drawable._2_copas),
        Carta("Oro", 3, R.drawable._3_oros),
        Carta("Espada", 7, R.drawable._7_espadas),
        Carta("Basto", 6, R.drawable._6_bastos),
        Carta("Copa", 5, R.drawable._5_copas),
        Carta("Oro", 4, R.drawable._4_oros),
        Carta("Espada", 3, R.drawable._3_espadas),
        Carta("Basto", 7, R.drawable._7_bastos)
    )

    var puntuacionJug1 = 0
    var puntuacionJug2 = 0
    var turnos = true
    var aciertos = 0
    var primero : ImageButton? = null
    var numPrimero : Int? = null
    var numSegundo : Int? = null
    var tablero = mutableListOf<ImageButton>()
    var imagenes = mutableListOf<Int>()
    var arrayDesordenado = mutableListOf<Int>()
    var bloqueo = false
    val handler = Handler(Looper.getMainLooper())
    var reiniciar = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMemory2PlayersBinding.inflate(inflater, container, false)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        navegacion()
        init()
        return  binding.root
    }

    private fun navegacion() {


        binding.exit?.setOnClickListener() {

            findNavController().navigate(R.id.action_memory2Players_to_home2)

        }

    }

    fun actualizarPuntuacion() {
        binding.puntJug1.text = "Puntuación: $puntuacionJug1"
        binding.puntJug2.text = "Puntuación: $puntuacionJug2"

    }



    fun cargarTablero() {
        tablero.add(binding.carta1)
        tablero.add(binding.carta2)
        tablero.add(binding.carta3)
        tablero.add(binding.carta4)
        tablero.add(binding.carta5)
        tablero.add(binding.carta6)
        tablero.add(binding.carta7)
        tablero.add(binding.carta8)
        tablero.add(binding.carta9)
        tablero.add(binding.carta10)
        tablero.add(binding.carta11)
        tablero.add(binding.carta12)
        tablero.add(binding.carta13)
        tablero.add(binding.carta14)
        tablero.add(binding.carta15)
        tablero.add(binding.carta16)
        tablero.add(binding.carta17)
        tablero.add(binding.carta18)
        tablero.add(binding.carta19)
        tablero.add(binding.carta20)
    }
    fun cargarImagenes() {

        imagenes.addAll(listOf(
            cartas[0].img,
            cartas[1].img,
            cartas[2].img,
            cartas[3].img,
            cartas[4].img,
            cartas[5].img,
            cartas[6].img,
            cartas[7].img,
            cartas[8].img,
            cartas[9].img
        ))

    }
    fun barajar(longitud: Int): ArrayList<Int> {
        val nums = arrayListOf<Int>()
        for (i in 0 until longitud * 2) {
            nums.add(i % longitud)
        }
        nums.shuffle()
        println(nums.joinToString(", "))
        return nums
    }
    fun comprobar(i: Int,imag: ImageButton) {

        if (primero == null) {
            primero = imag
            primero!!.setScaleType(ImageView.ScaleType.CENTER_CROP)
            primero!!.setImageResource(imagenes[arrayDesordenado.get(i)])
            primero!!.setEnabled(false)
            numPrimero = arrayDesordenado.get(i)

        }else {
            bloqueo = true
            imag.setScaleType(ImageView.ScaleType.CENTER_CROP)
            imag.setImageResource(imagenes[arrayDesordenado.get(i)])
            imag.setEnabled(false)
            numSegundo = arrayDesordenado.get(i)


            if (numPrimero == numSegundo) {
                println(numPrimero)
                primero = null
                bloqueo = false
                aciertos++

                if (turnos) {
                    puntuacionJug1++
                    puntuacionJug1++
                }
                else {
                    puntuacionJug2++
                    puntuacionJug2++
                }


                actualizarPuntuacion()

                if (aciertos == cartas.size) run {
                    var toast: Toast = Toast.makeText(context, "Has ganado", Toast.LENGTH_LONG)
                    toast.show()
                }

            } else {

                handler.postDelayed({
                    primero!!.setScaleType(ImageView.ScaleType.CENTER_CROP)
                    primero!!.setImageResource(R.drawable.reverso)
                    primero!!.setEnabled(true)
                    imag.setScaleType(ImageView.ScaleType.CENTER_CROP)
                    imag.setImageResource(R.drawable.reverso)
                    imag.setEnabled(true)
                    bloqueo = false
                    primero = null

                    if (turnos) {
                        puntuacionJug1--
                        turnos = false
                        binding.turno?.setText("Turno del jugador 2")
                        binding.turno?.setTextColor(Color.parseColor("#F44336"))
                    }
                    else {
                        puntuacionJug2--
                        turnos = true
                        binding.turno?.setText("Turno del jugador 1")
                        binding.turno?.setTextColor(Color.parseColor("#2196F3"))
                    }


                    actualizarPuntuacion()
                },1000)
            }

        }

    }
    fun reiniciarJuego() {

        puntuacionJug1 = 0
        puntuacionJug2 = 0
        aciertos = 0
        primero = null
        numPrimero = null
        numSegundo = null
        bloqueo = false
        turnos = true

        actualizarPuntuacion()

        arrayDesordenado = barajar(cartas.size)

        for (i in tablero.indices) {
            tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP)
            tablero[i].setImageResource(imagenes[arrayDesordenado[i]])
            tablero[i].isEnabled = false
        }

        handler.postDelayed({
            for (i in tablero.indices) {
                tablero[i].scaleType = ImageView.ScaleType.CENTER_CROP
                tablero[i].setImageResource(R.drawable.reverso)
                tablero[i].isEnabled = true
            }
        }, 500L)

    }

    private fun popUp() {

        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("¡Atención!")
        builder.setMessage("¿Preparados?")
            .setCancelable(false)
            .setPositiveButton("Sí") { dialog, _ ->

                for (i in tablero.indices) {
                    tablero[i].isEnabled = false
                    tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP)
                    //tablero[i].setImageResource(R.drawable.reverso)
                    tablero[i].setImageResource(imagenes[arrayDesordenado.get(i)])

                }

                handler.postDelayed({
                    for (i in tablero.indices) {
                        tablero[i].scaleType = ImageView.ScaleType.CENTER_CROP
                        // tablero[i].setImageResource(imagenes[arrayDesordenado[i]])
                        tablero[i].setImageResource(R.drawable.reverso)
                        tablero[i].isEnabled = true
                    }
                }, 500L)



                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }

    fun init() {

        cargarTablero()
        cargarImagenes()
        arrayDesordenado = barajar(cartas.size)

        popUp()



        binding.reiniciar.setOnClickListener {

            reiniciarJuego()

        }

        for (i in tablero.indices) {

            tablero[i].setOnClickListener {
                if (!bloqueo) {
                    comprobar(i, tablero[i])
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }


}