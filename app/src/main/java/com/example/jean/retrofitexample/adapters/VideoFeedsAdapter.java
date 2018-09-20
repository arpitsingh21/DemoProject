package com.example.jean.retrofitexample.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.Country;
import com.example.jean.retrofitexample.viewHolders.VideoFeedsRvHolder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Harikesh on 20/09/2018.
 */
public class VideoFeedsAdapter  extends RecyclerView.Adapter<VideoFeedsRvHolder>{

    private static final String TAG = VideoFeedsAdapter.class.getSimpleName();
    private final VideoFeedsRvInterface videoFeedsRvInterface;
    private final java.text.DateFormat timeFormat = java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT);
    Calendar calendar;
    List<Country> appointments;


    public VideoFeedsAdapter(long mills, VideoFeedsRvInterface videoFeedsRvInterface) {
        this.videoFeedsRvInterface = videoFeedsRvInterface;
        calendar = Calendar.getInstance();
        appointments = new ArrayList<>();
    }


    @Override
    public VideoFeedsRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final VideoFeedsRvHolder todayRvHolder = new VideoFeedsRvHolder(parent);
        todayRvHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoFeedsRvInterface.onAppointmentClick(appointments.get(todayRvHolder.getAdapterPosition()).appointmentUid);
            }
        });
        todayRvHolder.imageView_SendReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!appointments.get(todayRvHolder.getAdapterPosition()).isAppointmentServed) {
                    videoFeedsRvInterface.onSendReminderClick(appointments.get(todayRvHolder.getAdapterPosition()).appointmentUid);
                }//Log.d(TAG,"Onclick send reminder");

            }
        });
        todayRvHolder.uploadDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoFeedsRvInterface.onDocuploadClick(appointments.get(todayRvHolder.getAdapterPosition()));
                //Log.d(TAG,"Onclick send reminder");

            }
        });

        todayRvHolder.imageView_SendBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoFeedsRvInterface.onSendBillClick(appointments.get(todayRvHolder.getAdapterPosition()));
                //Log.d(TAG,"Onclick send reminder");

            }
        });
        return todayRvHolder;
    }

    @Override
    public void onBindViewHolder(VideoFeedsRvHolder holder, int position) {
        calendar.setTimeInMillis(appointments.get(holder.getAdapterPosition()).appointmentOn);
        holder.textTime.setText(timeFormat.format(calendar.getTime()));
//        switch (appointments.get(holder.getAdapterPosition()).appStatus) {
//            case 0:
//                holder.imageView_SendReminder.setImageResource(R.drawable.icon_send_reminder);
//                holder.imageView_SendReminder.setClickable(true);
//                holder.uploadDoc.setVisibility(View.VISIBLE);
//                holder.imageView_SendBill.setVisibility(View.VISIBLE);
//                break;
//            case 1:
//                holder.imageView_SendReminder.setImageResource(R.drawable.check);
//                holder.imageView_SendReminder.setClickable(false);
//                if (appointments.get(holder.getAdapterPosition()).billing_status == 1) {
//                    holder.imageView_SendBill.setEnabled(false);
//                    holder.imageView_SendBill.setVisibility(View.INVISIBLE);
//                } else {
//                    holder.imageView_SendBill.setVisibility(View.VISIBLE);
//                    holder.imageView_SendBill.setEnabled(true);
//                }
//                holder.uploadDoc.setVisibility(View.INVISIBLE);
//                break;
//            case 2:
//                holder.imageView_SendReminder.setImageResource(R.drawable.ic_warning_black_24dp);
//                holder.imageView_SendReminder.setClickable(false);
//                holder.uploadDoc.setVisibility(View.INVISIBLE);
//                if (appointments.get(holder.getAdapterPosition()).billing_status == 1) {
//                    holder.imageView_SendBill.setEnabled(false);
//                    holder.imageView_SendBill.setVisibility(View.INVISIBLE);
//                } else {
//                    holder.imageView_SendBill.setVisibility(View.VISIBLE);
//                    holder.imageView_SendBill.setEnabled(true);
//                }
//                break;
//        }
        holder.textPatientName.setText(appointments.get(holder.getAdapterPosition()).patient.patientName);
        holder.textAppointmentUId.setText(appointments.get(holder.getAdapterPosition()).appointmentUid);
        if (appointments.get(holder.getAdapterPosition()).patient.patientGender == 1) {
            holder.patientImage.setImageResource(R.drawable.female);
            holder.view.setBackgroundColor(Color.parseColor("#0000ff"));
        }
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        notifyItemInserted(appointments.size());
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
        notifyDataSetChanged();
    }

    public void setAppointmentsEmpty() {
        appointments = new ArrayList<>();
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return appointments != null ? appointments.size() : 0;
    }


    public void updateItemCount(int newCount) {

        notifyDataSetChanged();
    }

    public interface VideoFeedsRvInterface {
        void onAppointmentClick(String appointmentUid);

        void onSendReminderClick(String appointmentUid);

        void onDocuploadClick(Appointment appointment);

        void onSendBillClick(Appointment appointment);

    }
}
