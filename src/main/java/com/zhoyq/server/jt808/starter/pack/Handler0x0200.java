/*
 *  Copyright (c) 2020. 衷于栖 All rights reserved.
 *
 *  版权所有 衷于栖 并保留所有权利 2020。
 *  ============================================================================
 *  这不是一个自由软件！您只能在不用于商业目的的前提下对程序代码进行修改和
 *  使用。不允许对程序代码以任何形式任何目的的再发布。如果项目发布携带作者
 *  认可的特殊 LICENSE 则按照 LICENSE 执行，废除上面内容。请保留原作者信息。
 *  ============================================================================
 *  作者：衷于栖（feedback@zhoyq.com）
 *  博客：https://www.zhoyq.com
 *  创建时间：2020
 *
 */

package com.zhoyq.server.jt808.starter.pack;

import com.zhoyq.server.jt808.starter.core.Jt808Pack;
import com.zhoyq.server.jt808.starter.core.PackHandler;
import com.zhoyq.server.jt808.starter.entity.LocationInfo;
import com.zhoyq.server.jt808.starter.helper.Analyzer;
import com.zhoyq.server.jt808.starter.helper.ByteArrHelper;
import com.zhoyq.server.jt808.starter.helper.ResHelper;
import com.zhoyq.server.jt808.starter.service.DataService;
import com.zhoyq.server.jt808.starter.service.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 终端位置信息汇报
 * @author zhoyq <a href="mailto:feedback@zhoyq.com">feedback@zhoyq.com</a>
 * @date 2018/7/31
 */
@Slf4j
@Jt808Pack(msgId = 0x0200)
public class Handler0x0200 implements PackHandler {

    @Autowired
    private DataService dataService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private ThreadPoolExecutor tpe;

    @Override
    public byte[] handle( byte[] phoneNum, byte[] streamNum, byte[] msgId, byte[] msgBody) {
        log.info("0200 终端位置信息汇报 LocationInfoReport");

        tpe.execute(() -> {
            String phone = ByteArrHelper.toHexString(phoneNum);
            LocationInfo locationInfo = Analyzer.analyzeLocation(msgBody);

            dataService.terminalLocation(phone, locationInfo);
        });

        return ResHelper.getPlatAnswer(phoneNum,streamNum,msgId,(byte) 0);
    }
}
