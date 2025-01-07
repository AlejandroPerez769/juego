package com.example.juegos.barajaEspanyola

import android.content.pm.ActivityInfo
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.juegos.R
import com.example.juegos.databinding.FragmentMemoryBinding

class Memory : Fragment() {

    private var _binding: FragmentMemoryBinding? = null
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

    var puntuacion = 0
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
        _binding = FragmentMemoryBinding.inflate(inflater, container, false)
        init()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        return binding.root
    }

    fun actualizarPuntuacion() {
        binding.puntuacion.text = "Puntuación: $puntuacion"
    }
    fun fondoAnimacion() {
        val animationDrawable = binding.memory.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(2500)
        animationDrawable.start()
    }
    fun volverInicio() {
        binding.salir.setOnClickListener {
            findNavController().navigate(R.id.action_memory_to_home2)
        }
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
                puntuacion++
                puntuacion++
                aciertos++
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
                    puntuacion--
                    actualizarPuntuacion()
                },1000)
            }

        }

    }
    fun reiniciarJuego() {

        puntuacion = 0
        aciertos = 0
        primero = null
        numPrimero = null
        numSegundo = null
        bloqueo = false

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

    fun init() {
        fondoAnimacion()
        volverInicio()

            cargarTablero()
            cargarImagenes()
            arrayDesordenado = barajar(cartas.size)

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

    }

