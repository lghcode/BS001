package com.lghcode.bishe001;

import com.lghcode.bishe001.pojo.Iocation;
import com.lghcode.bishe001.service.IocationService;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lghcode@qq.com
 * @date 2019/10/14 17:36
 */
@Component
public class ChuanKouClient {
    /** 串口对象 */
    private SerialPort serialPort;

    @Autowired
    private IocationService iocationService;
    /**
     * 初始化
     */
    private void init() {
        // 通信的串口
        final String crtComName = "COM3";
        try {
            // 打开串口并获取串口对象
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(crtComName);
            // 设置超时时间为2000ms
            serialPort = (SerialPort) portIdentifier.open(crtComName, 2000);
            // 设置参数（包括波特率，数据位，停止位，奇偶校验）
            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            // 设置当有数据到达时唤醒监听接收线程
            serialPort.notifyOnDataAvailable(true);
            // 设置当通信中断时唤醒中断线程
            serialPort.notifyOnBreakInterrupt(true);
            // 接收并处理数据
            serialPort.addEventListener(new DataReceivedListener());
            System.out.println("打开串口[{}]成功"+crtComName);
        } catch (Exception e) {
            System.out.println("打开串口[{}]发生异常！！！"+crtComName);
        }
    }

    /**
     * 数据接收监听器
     */
    private class DataReceivedListener implements SerialPortEventListener {

        @Override
        public void serialEvent(SerialPortEvent event) {
            if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                // 这里可以写自己的逻辑
                readComm();
            }
        }
    }
    private void readComm(){
        InputStream inputStream = null;
        try {
            inputStream = serialPort.getInputStream();
            byte[] readerBuff = new byte[1];
            int m = inputStream.read(readerBuff);
            if (m > 0){
                System.out.println("data:"+readerBuff[0]);
                int a = readerBuff[0];
                if (a == 1){
                    Iocation iocation = iocationService.getIocation(14);
                    iocation.setStatus(0);
                    iocationService.update(iocation);
                }
            }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
