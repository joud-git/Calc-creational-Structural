package Calc;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JButton;

public final class Calculator extends javax.swing.JFrame {

    private String currentOperand;
    private String previousOperand;
    private String operation;

    private int x, y;

    public Calculator() {
        initComponents();
        getContentPane().setSize(400, 700);
        clear();
        addEvents();
    }

    // Wiring buttons to commands
    public void addEvents() {
        JButton[] btns = {
                btn0, btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8, btn9,
                btnDiv, btnDot, btnEqual, btnDel,
                btnMult, btnPlus, btnPlusSub, btnSub, btnClear
        };

        JButton[] numbers = {
                btn0, btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8, btn9
        };

        // Number buttons for NumberCommand
        for (JButton number : numbers) {
            number.addActionListener((ActionEvent e) -> {
                String digit = ((JButton) e.getSource()).getText();
                Command cmd = new NumberCommand(this, digit);
                cmd.execute();
            });
        }

        // Hover effects (كما هو عندك)
        for (JButton btn : btns) {
            btn.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    ((JButton) e.getSource()).setBackground(new Color(73, 69, 78));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Object b = e.getSource();
                    if (b == btnDiv || b == btnEqual || b == btnDel || b == btnMult
                            || b == btnSub || b == btnPlus || b == btnClear) {
                        ((JButton) b).setBackground(new Color(41, 39, 44));
                    } else {
                        ((JButton) b).setBackground(new Color(21, 20, 22));
                    }
                }
            });
        }
    }
   public void clear() {
        this.currentOperand = "";
        this.previousOperand = "";
        this.operation = "";
        this.updateDisplay();
    }

    public void appendNumber(String number) {
        if (this.currentOperand.equals("0") && number.equals("0")) {
            return;
        }

        if (number.equals(".") && this.currentOperand.contains(".")) {
            return;
        }

        if (this.currentOperand.equals("0")
                && !number.equals("0")
                && !number.equals(".")) {
            this.currentOperand = "";
        }

        this.currentOperand += number;
        this.updateDisplay();
    }

    public void chooseOperation(String operation) {
        if (this.currentOperand.equals("") && !this.previousOperand.equals("")) {
            this.operation = operation;
            this.updateDisplay();
        }
        if (this.currentOperand.equals("")) {
            return;
        }

        if (!this.previousOperand.equals("")) {
            this.compute();
        }

        this.operation = operation;
        this.previousOperand = this.currentOperand;
        this.currentOperand = "";
        this.updateDisplay();
    }

    public void compute() {
        if (this.currentOperand == null || this.currentOperand.isEmpty())
            return;
        if (this.previousOperand == null || this.previousOperand.isEmpty())
            return;
        if (this.operation == null || this.operation.isEmpty())
            return;

        double curr;
        double prev;
        try {
            curr = Double.parseDouble(this.currentOperand);
            prev = Double.parseDouble(this.previousOperand);
        } catch (NumberFormatException ex) {
            return;
        }

        // division by zero Error
        if (("÷".equals(this.operation) || "/".equals(this.operation)) && curr == 0.0) {
            this.clear();
            this.currentOperand = "Error";
            this.updateDisplay();
            return;
        }

        Operation op = OperationFactory.of(this.operation);
        if (op == null)
            return;

        double result = op.apply(prev, curr);

        if (result == Math.rint(result)) {
            this.currentOperand = Long.toString((long) result);
        } else {
            this.currentOperand = Double.toString(result);
        }

        this.previousOperand = "";
        this.operation = "";
        this.updateDisplay();
    }

    // ======== NEW helper methods used by external Command classes ========

    public void deleteLastDigit() {
        if (this.currentOperand != null && !this.currentOperand.equals("")) {
            this.currentOperand = this.currentOperand.substring(0, this.currentOperand.length() - 1);
            this.updateDisplay();
        }
    }

    public void toggleSign() {
        if (this.currentOperand != null && !this.currentOperand.isBlank()) {
            double tmp = -Double.parseDouble(this.currentOperand);

            if (tmp == Math.rint(tmp)) {
                this.currentOperand = Long.toString((long) tmp);
            } else {
                this.currentOperand = Double.toString(tmp);
            }
            this.updateDisplay();
        }
    }

    public void handleDot() {
        if (this.currentOperand == null || this.currentOperand.isBlank()) {
            appendNumber("0.");
        } else {
            appendNumber(".");
        }
    }

    public void updateDisplay() {
        current.setText(this.currentOperand);
        previous.setText(previousOperand + " " + this.operation);
    }

    /*
     * NETBEANS-GENERATED UI
     * 
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        app = new javax.swing.JPanel();
        resultsPanel = new javax.swing.JPanel();
        previous = new javax.swing.JTextField();
        current = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        btnDel = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnPlusSub = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btnMult = new javax.swing.JButton();
        btnSub = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();
        btnDot = new javax.swing.JButton();
        btnEqual = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        titleBar = new javax.swing.JPanel();
        btnMini = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 700));
        setResizable(false);

        app.setBackground(new java.awt.Color(0, 0, 0));
        app.setForeground(new java.awt.Color(255, 255, 255));
        app.setToolTipText("");

        resultsPanel.setBackground(new java.awt.Color(0, 0, 0));
        resultsPanel.setForeground(new java.awt.Color(255, 255, 255));

        previous.setEditable(false);
        previous.setBackground(new java.awt.Color(0, 0, 0));
        previous.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        previous.setForeground(new java.awt.Color(204, 204, 204));
        previous.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        previous.setBorder(null);

        current.setEditable(false);
        current.setBackground(new java.awt.Color(0, 0, 0));
        current.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        current.setForeground(new java.awt.Color(255, 255, 255));
        current.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        current.setBorder(null);

        javax.swing.GroupLayout resultsPanelLayout = new javax.swing.GroupLayout(resultsPanel);
        resultsPanel.setLayout(resultsPanelLayout);
        resultsPanelLayout.setHorizontalGroup(
                resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(resultsPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(resultsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(current, javax.swing.GroupLayout.DEFAULT_SIZE, 313,
                                                Short.MAX_VALUE)
                                        .addComponent(previous))
                                .addContainerGap(19, Short.MAX_VALUE)));
        resultsPanelLayout.setVerticalGroup(
                resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(resultsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(previous, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(current, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        buttonsPanel.setBackground(new java.awt.Color(21, 20, 22));

        btnDel.setBackground(new java.awt.Color(21, 20, 22));
        btnDel.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("←"); // backspace symbol that displays correctly
        btnDel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnDel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDel.setFocusPainted(false);
        btnDel.setIconTextGap(1);
        btnDel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnDel.setPreferredSize(new java.awt.Dimension(70, 70));
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(21, 20, 22));
        btnClear.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("C");
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.setFocusPainted(false);
        btnClear.setIconTextGap(1);
        btnClear.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnClear.setPreferredSize(new java.awt.Dimension(70, 70));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnPlusSub.setBackground(new java.awt.Color(21, 20, 22));
        btnPlusSub.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnPlusSub.setForeground(new java.awt.Color(255, 255, 255));
        btnPlusSub.setText("+/-");
        btnPlusSub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnPlusSub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlusSub.setFocusPainted(false);
        btnPlusSub.setIconTextGap(1);
        btnPlusSub.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPlusSub.setPreferredSize(new java.awt.Dimension(70, 70));
        btnPlusSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusSubActionPerformed(evt);
            }
        });

        btnDiv.setBackground(new java.awt.Color(21, 20, 22));
        btnDiv.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnDiv.setForeground(new java.awt.Color(255, 255, 255));
        btnDiv.setText("÷");
        btnDiv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnDiv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDiv.setFocusPainted(false);
        btnDiv.setIconTextGap(1);
        btnDiv.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnDiv.setPreferredSize(new java.awt.Dimension(70, 70));
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });

        btnMult.setBackground(new java.awt.Color(21, 20, 22));
        btnMult.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnMult.setForeground(new java.awt.Color(255, 255, 255));
        btnMult.setText("×");
        btnMult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnMult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMult.setFocusPainted(false);
        btnMult.setIconTextGap(1);
        btnMult.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMult.setPreferredSize(new java.awt.Dimension(70, 70));
        btnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultActionPerformed(evt);
            }
        });

        btnSub.setBackground(new java.awt.Color(21, 20, 22));
        btnSub.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnSub.setForeground(new java.awt.Color(255, 255, 255));
        btnSub.setText("-");
        btnSub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnSub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSub.setFocusPainted(false);
        btnSub.setIconTextGap(1);
        btnSub.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSub.setPreferredSize(new java.awt.Dimension(70, 70));
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        btnPlus.setBackground(new java.awt.Color(21, 20, 22));
        btnPlus.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnPlus.setForeground(new java.awt.Color(255, 255, 255));
        btnPlus.setText("+");
        btnPlus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnPlus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlus.setFocusPainted(false);
        btnPlus.setIconTextGap(1);
        btnPlus.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPlus.setPreferredSize(new java.awt.Dimension(70, 70));
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        btnDot.setBackground(new java.awt.Color(21, 20, 22));
        btnDot.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnDot.setForeground(new java.awt.Color(255, 255, 255));
        btnDot.setText(".");
        btnDot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnDot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDot.setFocusPainted(false);
        btnDot.setIconTextGap(1);
        btnDot.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnDot.setPreferredSize(new java.awt.Dimension(70, 70));
        btnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDotActionPerformed(evt);
            }
        });

        btnEqual.setBackground(new java.awt.Color(21, 20, 22));
        btnEqual.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnEqual.setForeground(new java.awt.Color(255, 255, 255));
        btnEqual.setText("=");
        btnEqual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btnEqual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEqual.setFocusPainted(false);
        btnEqual.setIconTextGap(1);
        btnEqual.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEqual.setPreferredSize(new java.awt.Dimension(70, 70));
        btnEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(21, 20, 22));
        btn9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("9");
        btn9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn9.setFocusPainted(false);
        btn9.setIconTextGap(1);
        btn9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn9.setPreferredSize(new java.awt.Dimension(70, 70));

        btn7.setBackground(new java.awt.Color(21, 20, 22));
        btn7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("7");
        btn7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn7.setFocusPainted(false);
        btn7.setIconTextGap(1);
        btn7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn7.setPreferredSize(new java.awt.Dimension(70, 70));

        btn8.setBackground(new java.awt.Color(21, 20, 22));
        btn8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("8");
        btn8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn8.setFocusPainted(false);
        btn8.setIconTextGap(1);
        btn8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn8.setPreferredSize(new java.awt.Dimension(70, 70));

        btn6.setBackground(new java.awt.Color(21, 20, 22));
        btn6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("6");
        btn6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn6.setFocusPainted(false);
        btn6.setIconTextGap(1);
        btn6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn6.setPreferredSize(new java.awt.Dimension(70, 70));

        btn4.setBackground(new java.awt.Color(21, 20, 22));
        btn4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("4");
        btn4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn4.setFocusPainted(false);
        btn4.setIconTextGap(1);
        btn4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn4.setPreferredSize(new java.awt.Dimension(70, 70));

        btn5.setBackground(new java.awt.Color(21, 20, 22));
        btn5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("5");
        btn5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn5.setFocusPainted(false);
        btn5.setIconTextGap(1);
        btn5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn5.setPreferredSize(new java.awt.Dimension(70, 70));

        btn3.setBackground(new java.awt.Color(21, 20, 22));
        btn3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("3");
        btn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.setFocusPainted(false);
        btn3.setIconTextGap(1);
        btn3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn3.setPreferredSize(new java.awt.Dimension(70, 70));

        btn1.setBackground(new java.awt.Color(21, 20, 22));
        btn1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("1");
        btn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.setFocusPainted(false);
        btn1.setIconTextGap(1);
        btn1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn1.setPreferredSize(new java.awt.Dimension(70, 70));

        btn2.setBackground(new java.awt.Color(21, 20, 22));
        btn2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("2");
        btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn2.setFocusPainted(false);
        btn2.setIconTextGap(1);
        btn2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn2.setPreferredSize(new java.awt.Dimension(70, 70));

        btn0.setBackground(new java.awt.Color(21, 20, 22));
        btn0.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn0.setForeground(new java.awt.Color(255, 255, 255));
        btn0.setText("0");
        btn0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 39, 44)));
        btn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn0.setFocusPainted(false);
        btn0.setIconTextGap(1);
        btn0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn0.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(buttonsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnPlusSub, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnEqual, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(37, Short.MAX_VALUE)));
        buttonsPanelLayout.setVerticalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonsPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(buttonsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPlusSub, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(buttonsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(buttonsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(buttonsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(buttonsPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEqual, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(25, Short.MAX_VALUE)));

        titleBar.setBackground(new java.awt.Color(18, 18, 18));
        titleBar.setForeground(new java.awt.Color(204, 204, 204));
        titleBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMini.setBackground(new java.awt.Color(18, 18, 18));
        btnMini.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btnMini.setForeground(new java.awt.Color(255, 255, 255));
        btnMini.setText("-");
        btnMini.setBorder(null);
        btnMini.setBorderPainted(false);
        btnMini.setFocusPainted(false);
        btnMini.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMiniMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMiniMouseExited(evt);
            }
        });
        btnMini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniActionPerformed(evt);
            }
        });
        titleBar.add(btnMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 30, 20));

        btnClose.setBackground(new java.awt.Color(18, 18, 18));
        btnClose.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("X");
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setFocusPainted(false);
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        titleBar.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 30, 20));

        title.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        title.setForeground(new java.awt.Color(204, 204, 204));
        title.setText(" Calculator");
        titleBar.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 20));

        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleBarMouseDragged(evt);
            }
        });
        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleBarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout appLayout = new javax.swing.GroupLayout(app);
        app.setLayout(appLayout);
        appLayout.setHorizontalGroup(
                appLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(appLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(appLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(resultsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE)));
        appLayout.setVerticalGroup(
                appLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appLayout.createSequentialGroup()
                                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(resultsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE)));

        getContentPane().add(app, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* Event Handler Using command */

   private void btnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDotActionPerformed
        Command cmd = new DotCommand(this);
        cmd.execute();
    }//GEN-LAST:event_btnDotActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        Command cmd = new ClearCommand(this);
        cmd.execute();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        Command cmd = new DeleteCommand(this);
        cmd.execute();
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        Command cmd = new OperationCommand(this, "+");
        cmd.execute();
    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultActionPerformed
        Command cmd = new OperationCommand(this, "×");
        cmd.execute();
    }//GEN-LAST:event_btnMultActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        Command cmd = new OperationCommand(this, "-");
        cmd.execute();
    }//GEN-LAST:event_btnSubActionPerformed

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivActionPerformed
        Command cmd = new OperationCommand(this, "÷");
        cmd.execute();
    }//GEN-LAST:event_btnDivActionPerformed

    private void btnEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEqualActionPerformed
        Command cmd = new EqualCommand(this);
        cmd.execute();
    }//GEN-LAST:event_btnEqualActionPerformed

    private void btnPlusSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusSubActionPerformed
        Command cmd = new ToggleSignCommand(this);
        cmd.execute();
    }//GEN-LAST:event_btnPlusSubActionPerformed

    private void btnMiniMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMiniMouseEntered
        btnMini.setBackground(new java.awt.Color(72, 72, 72));
    }// GEN-LAST:event_btnMiniMouseEntered

    private void btnMiniMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnMiniMouseExited
        btnMini.setBackground(new java.awt.Color(18, 18, 18));
    }// GEN-LAST:event_btnMiniMouseExited

    private void btnMiniActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMiniActionPerformed
        this.setState(ICONIFIED);
    }// GEN-LAST:event_btnMiniActionPerformed

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setBackground(new java.awt.Color(255, 102, 102));
    }// GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnCloseMouseExited
        btnClose.setBackground(new java.awt.Color(18, 18, 18));
    }// GEN-LAST:event_btnCloseMouseExited

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }// GEN-LAST:event_btnCloseActionPerformed

    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_titleBarMousePressed
        x = evt.getX();
        y = evt.getY();
    }// GEN-LAST:event_titleBarMousePressed

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_titleBarMouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x, yy - y);
    }// GEN-LAST:event_titleBarMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel app;
    private static javax.swing.JButton btn0;
    private static javax.swing.JButton btn1;
    private static javax.swing.JButton btn2;
    private static javax.swing.JButton btn3;
    private static javax.swing.JButton btn4;
    private static javax.swing.JButton btn5;
    private static javax.swing.JButton btn6;
    private static javax.swing.JButton btn7;
    private static javax.swing.JButton btn8;
    private static javax.swing.JButton btn9;
    private static javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private static javax.swing.JButton btnDel;
    private static javax.swing.JButton btnDiv;
    private static javax.swing.JButton btnDot;
    private static javax.swing.JButton btnEqual;
    private javax.swing.JButton btnMini;
    private static javax.swing.JButton btnMult;
    private static javax.swing.JButton btnPlus;
    private static javax.swing.JButton btnPlusSub;
    private static javax.swing.JButton btnSub;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JTextField current;
    private javax.swing.JTextField previous;
    private javax.swing.JPanel resultsPanel;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titleBar;
    // End of variables declaration//GEN-END:variables

}
